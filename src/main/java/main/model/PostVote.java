package main.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post_votes")
public class PostVote {
    /**
     * id лайка/дизлайка
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * тот, кто поставил лайк / дизлайк
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
    /**
     * пост, которому поставлен лайк / дизлайк
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;
    /**
     * дата и время лайка / дизлайка
     */
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime time;
    /**
     * лайк или дизлайк: 1 или -1
     */
    @Column(nullable = false)
    private byte value;
}