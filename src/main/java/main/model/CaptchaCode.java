package main.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "captcha_codes")
public class CaptchaCode {
    /**
     * id каптча
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * дата и время генерации кода капчи
     */
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime time;
    /**
     * код, отображаемый на картинке капчи
     */
    @Column(columnDefinition = "TINYTEXT", nullable = false)
    private String code;
    /**
     * код, передаваемый в параметре
     */
    @Column(columnDefinition = "TINYTEXT", name = "secret_code", nullable = false)
    private String secretCode;
}
