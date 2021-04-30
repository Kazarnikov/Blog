package main.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Component
public class InitResponse {

    @Value("${blog.title}")
    private String title;

    @Value("${blog.subTitle}")
    private String subTitle;

    @Value("${blog.phone}")
    private String phone;

    @Value("${blog.email}")
    private String email;

    @Value("${blog.copyright}")
    private String copyright;

    @Value("${blog.copyrightFrom}")
    private String copyrightFrom;
}

