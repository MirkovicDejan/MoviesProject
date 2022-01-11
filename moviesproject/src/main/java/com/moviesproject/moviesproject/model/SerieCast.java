package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="SerieCast")
@NoArgsConstructor
@Data
public class SerieCast {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="serieCastId",insertable = false,updatable = false)
    private Integer serieCastId;

    @ManyToOne
    @JoinColumn(name="seasonId")
    private Season season;

    @ManyToOne
    @JoinColumn(name ="movieRoleId")
    private MovieRole movieRole;

    @ManyToOne
    @JoinColumn(name="moviePeopleId")
    private  MoviePeople moviePeople;



}
