package main.service.interfaces;

import main.api.response.TagsResponse;
import main.service.TagServiceImpl;

/**
 * PostService interface for {@link TagServiceImpl} class.
 */
public interface TagService {

    TagsResponse findTags(String query);
}
