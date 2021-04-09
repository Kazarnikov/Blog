package main.model.repository;

import main.DTO.interfaces.PostAnswer;
import main.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Post} class.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    @Query(value = "SELECT * FROM posts " +
            "WHERE is_active = 1 AND moderation_status = 'ACCEPTED'", nativeQuery = true)
    List<Post> findByActiveStatus();

    @Query(value = "SELECT p.id, p.time AS timestamp, u.id userId, u.name userName, p.title,\n" +
            "CASE WHEN LENGTH(p.text) > 153\n" +
            "     THEN CONCAT(SUBSTR(p.text, 1, 150), '...')\n" +
            "     ELSE p.text END AS announce,\n" +
            "SUM(CASE WHEN pv.value = '1' THEN 1 ELSE 0 END) AS likeCount, \n" +
            "SUM(CASE WHEN pv.value = '-1' THEN 1 ELSE 0 END) AS dislikeCount,\n" +
            "p.view_count AS viewCount\n" +
            "FROM posts AS p\n" +
            "LEFT JOIN users AS u ON p.user_id = u.id\n" +
            "LEFT JOIN post_votes AS pv ON pv.post_id = p.id\n" +
            "WHERE is_active = 1 AND moderation_status = 'ACCEPTED'\n" +
            "GROUP BY p.id", nativeQuery = true)
    Page<PostAnswer> findAllPost(Pageable pageable);
}