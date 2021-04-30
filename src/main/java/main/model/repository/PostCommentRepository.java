package main.model.repository;

import main.model.PostComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link PostComment} class.
 */
@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Long> {

    @Query("SELECT count(pc.postId) FROM PostComment pc WHERE pc.postId = :id")
    long countAllById(@Param("id") Long id);

    List<PostComment> findAllByPostIdOrderByTimeDesc(Long id);
}

