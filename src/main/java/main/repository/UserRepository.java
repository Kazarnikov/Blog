package main.repository;

import main.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link User} class.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
