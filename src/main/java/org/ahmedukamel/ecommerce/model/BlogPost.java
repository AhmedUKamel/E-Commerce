package org.ahmedukamel.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogPostId;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dateCreated;
    private String pictureUrl = "";

    @JsonIgnore
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlogPostDetail> blogPostDetails = new HashSet<>();
}