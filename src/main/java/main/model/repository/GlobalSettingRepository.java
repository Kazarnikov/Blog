package main.model.repository;

import main.model.GlobalSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link GlobalSetting} class.
 */
@Repository
public interface GlobalSettingRepository extends CrudRepository<GlobalSetting, Long> {
}
