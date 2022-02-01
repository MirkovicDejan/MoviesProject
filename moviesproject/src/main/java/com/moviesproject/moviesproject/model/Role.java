package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Role")
@NoArgsConstructor
@Data
public class Role {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private Integer roleId;

    @Column(name="name",length = 30,unique = true)
    private String name;

    public Role(String name){
        this.name = name;
    }




}
