package main.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    private int id;
    /**
     * дата и время генерации кода капчи
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    /**
     * код, отображаемый на картинке капчи
     */
    @Column(nullable = false)
    private byte code;
    /**
     * код, передаваемый в параметре
     */
    @Column(name = "secret_code",nullable = false)
    private byte secretCode;
}
