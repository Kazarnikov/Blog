package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import main.DTO.PostCommentByIdDTO;
import main.DTO.PostUserDTO;
import org.springframework.stereotype.Component;

import java.util.List;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostByIdResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("timestamp")
    private long time;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("user")
    private PostUserDTO user;

    @JsonProperty("title")
    private String title;

    @JsonProperty("text")
    private String text;

    @JsonProperty("likeCount")
    private long likeCount;

    @JsonProperty("dislikeCount")
    private long dislikeCount;

    @JsonProperty("viewCount")
    private long viewCount;

    @JsonProperty("comments")
    private List<PostCommentByIdDTO> comments;

    @JsonProperty("tags")
    private List<String> tags;
}
