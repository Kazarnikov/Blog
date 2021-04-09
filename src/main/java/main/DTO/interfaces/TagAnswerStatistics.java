package main.DTO.interfaces;

import main.api.response.TagResponse;

/**
 * Forming response for {@link TagResponse} class
 */
public interface TagAnswerStatistics {

    String getName();

    long getCount();
}
