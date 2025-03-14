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
@Table(name = "key_word")
public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_word_id")
    private int keyWordId;

    @Column(name = "article_id")
    @NotNull(message = "Article ID is required")
    @JoinColumn(name = "article_id")
    @ManyToOne
    private Article article;

    @NotNull(message = "Content is required")
    @Size(min = 3, max = 255, message = "Content must be between 3 and 255 characters")
    private String content;

    @Column(name = "created_at")
    @NotNull(message = "Created at is required")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
