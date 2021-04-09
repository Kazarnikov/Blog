package main.api.response;

import lombok.Data;
import main.DTO.PostDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class PostResponse {
    private long count = 0;
    private List<PostDTO> posts;

    public PostResponse() {
        this.posts = new ArrayList<>();
    }
}
