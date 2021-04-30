package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StatisticsResponse {

    @JsonProperty("postsCount")
    private Long postsCount;

    @JsonProperty("likesCount")
    private Long likesCount;

    @JsonProperty("dislikesCount")
    private Long dislikesCount;

    @JsonProperty("viewsCount")
    private Long viewsCount;

    @JsonProperty("firstPublication")
    private Long firstPublication;
}
