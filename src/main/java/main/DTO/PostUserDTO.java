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
public class PostUserDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;
}
