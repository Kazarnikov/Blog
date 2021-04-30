package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import main.DTO.PostDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostsResponse {

    @JsonProperty("count")
    private long count;

    @JsonProperty("posts")
    private List<PostDTO> posts;

}
