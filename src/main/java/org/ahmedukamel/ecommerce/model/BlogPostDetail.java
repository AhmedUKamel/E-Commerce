package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "blog_post_details")
public class BlogPostDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title = "";
    @Column(columnDefinition = "TEXT")
    private String content = "";
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;
    @ManyToOne
    @JoinColumn(name = "blog_post_id", nullable = false)
    private BlogPost blogPost;
}
