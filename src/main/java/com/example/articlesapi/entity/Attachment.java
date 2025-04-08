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
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private int attachmentId;

    @NotNull(message = "Article ID is required")
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull(message = "Link is required")
    @Size(min = 3, max = 255, message = "Link must be between 3 and 255 characters")
    private String link;

    @NotNull(message = "Description is required")
    @Size(min = 3, max = 255, message = "Description must be between 3 and 255 characters")
    private String description;

    @NotNull(message = "Created at is required")
    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
