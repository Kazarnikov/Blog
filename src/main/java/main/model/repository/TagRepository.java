package main.model.repository;

import main.DTO.interfaces.TagAnswerStatistics;
import main.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Tag} class.
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

    @Query(value = "SELECT t.name AS name, count(t.name) AS count FROM tags AS t\n" +
            "LEFT JOIN tag2post AS t2p ON t.id = t2p.tag_id \n" +
            "LEFT JOIN posts AS p ON t2p.post_id = p.id \n" +
            "WHERE is_active = 1 AND moderation_status = 'ACCEPTED' \n" +
            "GROUP BY name ORDER BY count DESC", nativeQuery = true)
    List<TagAnswerStatistics> findTags();

    @Query(value = "SELECT t.name AS name, count(t.name) AS count FROM tags AS t\n" +
            "LEFT JOIN tag2post AS t2p ON t.id = t2p.tag_id \n" +
            "LEFT JOIN posts AS p ON t2p.post_id = p.id \n" +
            "WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND tags.name LIKE %:query% " +
            "GROUP BY name ORDER BY count DESC", nativeQuery = true)
    List<TagAnswerStatistics> findByTag(@Param("query") String query);
}
