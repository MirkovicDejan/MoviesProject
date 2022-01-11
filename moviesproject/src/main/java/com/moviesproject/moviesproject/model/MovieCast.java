package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MovieCast")
@NoArgsConstructor
@Data
public class MovieCast {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movieCastId",insertable = false,updatable = false)
    private Integer movieCastIdId;

    @ManyToOne()
    @JoinColumn(name="contentId")
    private Content content;

    @ManyToOne()
    @JoinColumn(name="movieRoleId")
    private MovieRole movieRole;

    @ManyToOne()
    @JoinColumn(name="moviePeopleId")
    private MoviePeople moviePeople;
}
