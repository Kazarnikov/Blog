package main.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "tags")
public class Tag {
    /**
     * id тэга
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * текст тэга
     */
    @Column(nullable = false)
    private String name;
    /**
     * список постов по тэгам
     */
    @ManyToMany(mappedBy = "postTags")
    private Set<Post> listPosts;
}