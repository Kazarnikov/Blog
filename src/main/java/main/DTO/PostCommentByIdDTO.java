package main.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentByIdDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("timestamp")
    private long time;

    @JsonProperty("text")
    private String text;

    @JsonProperty("user")
    private PostUserByIdDTO user;
}
