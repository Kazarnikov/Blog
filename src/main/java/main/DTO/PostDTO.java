package main.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("timestamp")
    private long time;

    @JsonProperty("user")
    private PostUserDTO user;

    @JsonProperty("title")
    private String title;

    @JsonProperty("announce")
    private String announce;

    @JsonProperty("likeCount")
    private long likeCount;

    @JsonProperty("dislikeCount")
    private long dislikeCount;

    @JsonProperty("commentCount")
    private long commentCount;

    @JsonProperty("viewCount")
    private long viewCount;
}
