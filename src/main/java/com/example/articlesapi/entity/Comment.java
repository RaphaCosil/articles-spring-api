package com.example.articlesapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "article_id")
    @NotNull(message = "Article ID is required")
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "user_id")
    @NotNull(message = "User ID is required")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "Content is required")
    @Size(min = 3, max = 255, message = "Content must be between 3 and 255 characters")
    private String content;

    @Column(name = "created_at")
    @NotNull(message = "Created at is required")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
