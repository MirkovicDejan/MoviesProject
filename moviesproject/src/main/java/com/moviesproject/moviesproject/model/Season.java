package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Season")
@Entity
@NoArgsConstructor
@Data
public class Season {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="seasonId",insertable = false,updatable = false)
    private Integer seasonId;

    @ManyToOne
    @JoinColumn(name="contentId")
    private Content content;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="seasonNumber")
    private Integer seasonNumber;




}
