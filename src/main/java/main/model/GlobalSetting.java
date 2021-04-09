package main.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "global_settings")
public class GlobalSetting {
    /**
     * id настройки
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * системное имя настройки
     */
    @Column(nullable = false)
    private String code;
    /**
     * название настройки
     */
    @Column(nullable = false)
    private String name;
    /**
     * значение настройки
     */
    @Column(nullable = false)
    private String value;
}
