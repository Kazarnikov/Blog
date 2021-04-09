package main.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("timestamp")
    private long time;

    @JsonProperty("user")
    private UserDTO user;

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
