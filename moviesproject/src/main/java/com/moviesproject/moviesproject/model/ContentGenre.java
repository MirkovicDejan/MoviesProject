package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// u ovoj klasi ce moyda biti greska
@Table(name="ContentGenre")
@Entity
@NoArgsConstructor
@Data
public class ContentGenre {
    @Id
    @GeneratedValue
    @Column(name="contentGenreId",insertable = false,updatable = false)
    private Integer contentGenereId;

    @ManyToOne
    @JoinColumn(name="genreId")
    private Genre genre;



    @ManyToOne
    @JoinColumn(name="contentId")
    private Content content;



}
