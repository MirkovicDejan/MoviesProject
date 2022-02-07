package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Genre")
@Entity
@NoArgsConstructor
@Data
public class Genre {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="genreId",insertable = false,updatable = false)
    private Integer genreId;

    @Column(name="name")
    private String name;



}
