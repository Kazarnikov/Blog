package main.model;

import lombok.Data;
import main.model.enums.ModerationStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private int id;
    /**
     * скрыта или активна публикация: 0 или 1
     */
    @Column(name = "is_active", nullable = false)
    private byte isActive;
    /**
     * статус модерации, по умолчанию значение "NEW".
     */
    @Enumerated(EnumType.STRING)
    @Column(/*columnDefinition = "ENUM",*/ name = "moderation_status", nullable = false, length = 10)
    private ModerationStatus status;
    /**
     * ID пользователя-модератора, принявшего решение, или NULL
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "moderator_id")
    private User moderatorId;
    /**
     * автор поста
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    /**
     * дата и время публикации поста
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    /**
     * заголовок поста
     */
    @Column(nullable = false)
    private String title;
    /**
     * текст поста
     */
    @Column(columnDefinition = "Text", nullable = false)
    private String text;
    /**
     * количество просмотров поста
     */
    @Column(name = "view_count", nullable = false)
    private int viewCount;
    /**
     * список тэгов для постов
     */
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "tag2post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> postTags;
}
