package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MovieRole")
@NoArgsConstructor
@Data
public class MovieRole {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movieRoleId",insertable = false,updatable = false)
    private Integer movieRoleId;

    @Column(name="name",length = 20)
    private String name;



}
