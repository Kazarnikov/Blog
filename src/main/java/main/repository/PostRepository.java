package main.repository;

import main.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Post} class.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
