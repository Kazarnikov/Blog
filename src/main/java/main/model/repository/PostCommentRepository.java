package main.model.repository;

import main.model.PostComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link PostComment} class.
 */
@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Integer> {
    @Query(value = "SELECT sum(CASE WHEN post_id = :id THEN 1 ELSE 0 END) count " +
            "FROM post_comments", nativeQuery = true)
    long findAllById(@Param("id") long id);
}
