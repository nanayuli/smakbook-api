package com.smakbook.model;

import com.smakbook.util.NovelStatusConverter;
import com.smakbook.util.TranslationStatusConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class Novel
 * @since 20/11/2024 — 18.34
 **/
@Entity
@Table(name = "novel")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, exclude = {"genres", "tags"})
public class Novel extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "translator_id")
    private User translator;

    @Column(name = "cover_image_path")
    private String coverImagePath;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id")
    private Set<AlternativeTitle> alternativeTitles = new HashSet<>();

    private String description;

    private String country;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "novel_status")
    @Convert(converter = NovelStatusConverter.class)
    private NovelStatus novelStatus;

    @Column(name = "translation_status")
    @Convert(converter = TranslationStatusConverter.class)
    private TranslationStatus translationStatus;

    @Column(name = "is_published")
    private boolean isPublished;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "novel_genre",
            joinColumns = @JoinColumn(name = "novel_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "novel_tag",
            joinColumns = @JoinColumn(name = "novel_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
}
