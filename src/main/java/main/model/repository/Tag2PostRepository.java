package main.model.repository;

import main.model.Tag2Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Tag2Post} class.
 */
@Repository
public interface Tag2PostRepository extends CrudRepository<Tag2Post, Integer> {
}