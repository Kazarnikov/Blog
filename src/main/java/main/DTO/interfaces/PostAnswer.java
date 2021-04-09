package main.DTO.interfaces;

import main.api.response.PostResponse;

import java.time.LocalDateTime;

/**
 * Forming response for {@link PostResponse} class
 */
public interface PostAnswer {

    long getId();

    LocalDateTime getTimestamp();

    long getUserId();

    String getUserName();

    String getTitle();

    String getAnnounce();

    long getLikeCount();

    long getDislikeCount();

//    long getCommentCount();

    long getViewCount();
}
