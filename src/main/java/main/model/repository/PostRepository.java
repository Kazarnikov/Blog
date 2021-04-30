package main.model.repository;

import main.model.Post;
import main.model.enums.ModerationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Post} class.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента
     */
    @Query("FROM Post p WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP")
    Page<Post> findAll(Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и сортированы по лайкам
     */
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN PostVote pv ON pv.postId = p.id AND pv.value = 1 " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP " +
            "GROUP BY p.id ORDER BY count(pv.value) DESC")
    Page<Post> findAllByLikePopular(Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и сортированы по количеству комментарий
     */
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN PostComment pc ON pc.postId = p.id " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP " +
            "GROUP BY p.id ORDER BY count(pc.postId) DESC")
    Page<Post> findAllByCommentPopular(Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и по тегу
     */
    @Query("SELECT p FROM Post p " +
            "JOIN Tag2Post tp ON p.id = tp.postId " +
            "JOIN Tag t on tp.tagId = t.id " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP " +
            "and t.name = :tag ORDER BY p.time DESC")
    Page<Post> findAllByTag(@Param("tag") String tag, Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и по запросу
     */
    @Query("SELECT p FROM Post p " +
            "WHERE (p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP) " +
            "AND (p.text LIKE %:query% or p.title LIKE %:query%) " +
            "ORDER BY p.time DESC")
    Page<Post> findAllBySearch(@Param("query") String query, Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и по дате
     */
    @Query("SELECT p FROM Post p " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP AND date(p.time) = date(:date) " +
            "ORDER BY p.time DESC")
    Page<Post> findPostByDate(@Param("date") String date, Pageable pageable);

    /**
     * Поиск только активные и одобренные посты
     * с датой публикации не позднее текущего момента и по запросу
     */
    @Query("SELECT p FROM Post p " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP ORDER BY p.time ASC")
    List<Post> numberPostsCalendar();

    /**
     * Увеличивает количество просмотров по ид поста
     */
    @Modifying
    @Query("UPDATE Post p set p.viewCount = p.viewCount + 1 where p.id = :id")
    int viewCount(@Param("id") Long id);

    /**
     * Поиск только активного и одобренного поста
     * с датой публикации не позднее текущего момента и по ид поста
     */
    @Query("SELECT p FROM Post p " +
            "WHERE p.isActive = 1 AND p.status = 'ACCEPTED' AND p.time < CURRENT_TIMESTAMP AND p.id = :id")
    Post findPostById(@Param("id") Long id);

    Page<Post> findAllByStatusAndIsActive(@Param("status") ModerationStatus status,
                                          @Param("isActive") byte isActive,
                                          Pageable pageable);
}