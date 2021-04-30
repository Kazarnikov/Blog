package main.model.repository;

import main.model.CaptchaCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link CaptchaCode} class.
 */
@Repository
public interface CaptchaCodeRepository extends CrudRepository<CaptchaCode, Long> {
}
