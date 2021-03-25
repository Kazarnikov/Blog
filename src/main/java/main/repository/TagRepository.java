package main.repository;

import main.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Tag} class.
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
