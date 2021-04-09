package main.service.interfaces;

import main.api.response.TagResponse;
import main.service.TagServiceImpl;

/**
 * PostService interface for {@link TagServiceImpl} class.
 */
public interface TagService {
    TagResponse findTags(String query);
}
