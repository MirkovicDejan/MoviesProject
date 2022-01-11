package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Role")
@NoArgsConstructor
@Data
public class Role {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId",insertable = false,updatable = false)
    private Integer roleId;

    @Column(name="name",length = 30)
    private String name;



}
