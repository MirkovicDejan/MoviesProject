package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Country")
@Entity
@NoArgsConstructor
@Data
public class Country {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="countryId",insertable = false,updatable = false)
    private Integer countryId;

    @Column(name="name",length = 100)
    private String name;

    @Column(name="code",length = 10)
    private char code [];

}
