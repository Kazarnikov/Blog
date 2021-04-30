package main.model;

import lombok.Data;

import javax.persistence.*;
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
    private Long id;
    /**
     * тот, кто поставил лайк / дизлайк
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;
    /**
     * пост, которому поставлен лайк / дизлайк
     */
    @Column(name = "post_id", nullable = false)
    private Long postId;
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