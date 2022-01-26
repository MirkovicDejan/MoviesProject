package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Genere")
@Entity
@NoArgsConstructor
@Data
public class Genre {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="genereId",insertable = false,updatable = false)
    private Integer genereId;

    @Column(name="name")
    private String name;



}
