package main.model.repository;

import main.model.PostVote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link PostVote} class.
 */
@Repository
public interface PostVoteRepository extends CrudRepository<PostVote, Long> {

    @Query("SELECT count(pv.postId) FROM PostVote pv WHERE pv.value = 1 AND pv.postId = :id")
    long countLikeById(@Param("id") long id);

    @Query("SELECT count(pv.postId) FROM PostVote pv WHERE pv.value = 1 AND pv.postId = :id")
    long countDislikeById(@Param("id") long id);
}
