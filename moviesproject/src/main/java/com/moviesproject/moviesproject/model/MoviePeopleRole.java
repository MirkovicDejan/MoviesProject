package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MoviePeopleRole")
@NoArgsConstructor
@Data
public class MoviePeopleRole {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="moviePeopleRoleId",insertable = false,updatable = false)
    private Integer moviePeopleRoleId;

    @ManyToOne
    @JoinColumn(name="movieRoleId")
    private MovieRole movieRole;

    @ManyToOne
    @JoinColumn(name="moviePeopleId")
    private MoviePeople moviePeople;

}
