package com.moviesproject.moviesproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Content")
@Entity
@NoArgsConstructor
@Data
public class Content {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contentId")
    private Integer contentId;

    @ManyToOne
    @JoinColumn(name = "contentTypeId")
    private ContentType contentType;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "releaseDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @Column(name = "rating")
    private float rating;

    @Lob
    private String coverLink;

    @Lob
    private String trailerLink;

    public Content(ContentType contentType, Country country, Language language, String title, Integer year, Integer duration, Date releaseDate, float rating, String coverLink, String trailerLink) {
        this.contentType = contentType;
        this.country = country;
        this.language = language;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.coverLink = coverLink;
        this.trailerLink = trailerLink;
    }
}
