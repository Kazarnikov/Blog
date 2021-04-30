package main.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tag2post")
public class Tag2Post {

    @EmbeddedId
    public KeyId keyId;
    /**
     * id тэга
     */
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tagId;
    /**
     * id поста
     */
    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;

    @Data
    @Embeddable
    @EqualsAndHashCode
    public static class KeyId implements Serializable {

        @Column(name = "tag_id")
        private Long tagId;

        @Column(name = "post_id")
        private Long postId;

        public KeyId() {
        }

        public KeyId(Long tagId, Long postId) {
            this.tagId = tagId;
            this.postId = postId;
        }
    }
}


