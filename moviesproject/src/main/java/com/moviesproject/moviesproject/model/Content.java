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
    @Column(name = "contentId", insertable = false, updatable = false)
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
}
