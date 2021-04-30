package main.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post_comments")
public class PostComment {
    /**
     * id комментария
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * комментарий, на который оставлен этот комментарий (может
     * быть NULL, если комментарий оставлен просто к посту)
     */
    @Column(name = "parent_id")
    private Long parentId;
    /**
     * автор комментария
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    /**
     * пост, к которому написан комментарий
     */
    @Column(name = "post_id", nullable = false)
    private Long postId;
    /**
     * дата и время комментария
     */
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime time;
    /**
     * текст комментария
     */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
}