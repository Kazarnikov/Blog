package main.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    /**
     * id пользователя
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * является ли пользователь модератором
     */
    @Column(name = "is_moderator", nullable = false)
    private byte isModerator;
    /**
     * дата и время регистрации пользователя
     */
    @Column(name = "reg_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regTime;
    /**
     * имя пользователя
     */
    @Column(nullable = false)
    private String name;
    /**
     * e-mail пользователя
     */
    @Column(nullable = false)
    private String email;
    /**
     * хэш пароля пользователя
     */
    @Column(nullable = false)
    private String password;
    /**
     * код для восстановления пароля, может быть NULL
     */
    private String code;
    /**
     * фотография (ссылка на файл), может быть NULL
     */
    @Column(columnDefinition = "Text")
    private String photo;
}