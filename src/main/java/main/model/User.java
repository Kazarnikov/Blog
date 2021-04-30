package main.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Long id;
    /**
     * является ли пользователь модератором
     */
    @Column(name = "is_moderator", nullable = false)
    private byte isModerator;
    /**
     * дата и время регистрации пользователя
     */
    @Column(columnDefinition = "DATETIME", name = "reg_time", nullable = false)
    private LocalDateTime regTime;
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
    @Column(columnDefinition = "TEXT")
    private String photo;

    public Role getRole() {
        return isModerator == 1 ? Role.MODERATOR : Role.USER;
    }

    public boolean getIsModerator() {
        return isModerator == 1;
    }
}