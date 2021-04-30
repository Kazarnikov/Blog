package main.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LoginRequest {

    @JsonProperty("e_mail")
    private String email;

    @JsonProperty("password")
    private String password;
}

