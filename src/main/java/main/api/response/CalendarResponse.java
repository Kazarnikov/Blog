package main.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Component
public class CalendarResponse {

    @JsonProperty("years")
    private List<Integer> years;

    @JsonProperty("posts")
    private Map<LocalDate, Integer> posts;
}
