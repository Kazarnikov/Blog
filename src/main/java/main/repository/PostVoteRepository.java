package main.repository;

import main.model.PostVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link PostVote} class.
 */
@Repository
public interface PostVoteRepository extends CrudRepository<PostVote, Integer> {
}
