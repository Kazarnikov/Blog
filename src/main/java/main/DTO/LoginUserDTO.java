package main.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserDTO {

    @ToString.Exclude
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("moderation")
    private boolean moderation;

    @JsonProperty("moderationCount")
    private Long moderationCount;

    @JsonProperty("settings")
    private boolean settings;
}
