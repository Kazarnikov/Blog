package main.api.response;

import lombok.Data;
import main.DTO.TagDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class TagResponse {
    private List<TagDTO> tags;

    public TagResponse() {
        this.tags = new ArrayList<>();
    }
}
