package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Episode")
@Entity
@NoArgsConstructor
@Data
public class Episode {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="episodeId",insertable = false,updatable = false)
    private Integer episodeId;

    @ManyToOne
    @JoinColumn(name="seasonId")
    private Season season;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="duration")
    private Integer duration;

    @Column(name="episodeNumber")
    private Integer episodeNumber;

}
