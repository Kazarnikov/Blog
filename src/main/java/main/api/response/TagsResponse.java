package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import main.DTO.TagDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TagsResponse {

    @JsonProperty("tags")
    private List<TagDTO> tags;
}
