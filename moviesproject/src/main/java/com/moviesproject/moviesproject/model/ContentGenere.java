package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// u ovoj klasi ce moyda biti greska
@Table(name="ContentGenere")
@Entity
@NoArgsConstructor
@Data
public class ContentGenere {
    @Id
    @GeneratedValue
    @Column(name="contentGenereId",insertable = false,updatable = false)
    private Integer contentGenereId;

    @ManyToOne
    @JoinColumn(name="genereId")
    private Genre genre;



    @ManyToOne
    @JoinColumn(name="contentId")
    private Content content;



}
