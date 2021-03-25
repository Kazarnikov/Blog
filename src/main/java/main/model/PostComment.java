package main.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "post_comments")
public class PostComment {
    /**
     * Список комментарии к комментарию
     */
    @Column(nullable = false)
    @OneToMany(mappedBy = "parentId",
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<PostComment> postCommentList;
    /**
     * id комментария
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * комментарий, на который оставлен этот комментарий (может
     * быть NULL, если комментарий оставлен просто к посту)
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "parent_id", nullable = false)
    private PostComment parentId;
    /**
     * автор комментария
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    /**
     * пост, к которому написан комментарий
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;
    /**
     * дата и время комментария
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    /**
     * текст комментария
     */
    @Column(nullable = false, columnDefinition = "Text")
    private String text;
}