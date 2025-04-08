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
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;

    @NotNull(message = "Sender ID is required")
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @NotNull(message = "Title is required")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @NotNull(message = "Content is required")
    @Size(min = 3, max = 1000, message = "Content must be between 3 and 1000 characters")
    private String content;

    @NotNull(message = "Created at is required")
    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
