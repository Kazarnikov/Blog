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
public class TagDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("weight")
    private double weight;
}
