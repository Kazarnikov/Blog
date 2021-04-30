package main.model;

import lombok.Data;
import lombok.ToString;
import main.model.enums.ModerationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post {

    /**
     * id поста
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * скрыта или активна публикация: 0 или 1
     */
    @Column(name = "is_active", nullable = false)
    private byte isActive;
    /**
     * статус модерации, по умолчанию значение "NEW".
     */
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('')", name = "moderation_status", nullable = false)
    private ModerationStatus status;
    /**
     * ID пользователя-модератора, принявшего решение, или NULL
     */
    @Column(name = "moderator_id")
    private Long moderatorId;
    /**
     * автор поста
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    /**
     * дата и время публикации поста
     */
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime time;
    /**
     * заголовок поста
     */
    @Column(nullable = false)
    private String title;
    /**
     * текст поста
     */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
    /**
     * количество просмотров поста
     */
    @Column(name = "view_count", nullable = false)
    private long viewCount;
    /**
     * список тэгов для постов
     */
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "tag2post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tagsList;
}
