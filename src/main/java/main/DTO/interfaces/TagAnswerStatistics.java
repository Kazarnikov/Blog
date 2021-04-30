package main.DTO.interfaces;

import main.api.response.TagsResponse;

/**
 * Forming response for {@link TagsResponse} class
 */
public interface TagAnswerStatistics {

    String getName();

    long getCount();
}
