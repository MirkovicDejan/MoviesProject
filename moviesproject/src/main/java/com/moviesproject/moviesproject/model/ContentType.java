package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="ContentType")
@Entity
@NoArgsConstructor
@Data
public class ContentType {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="contentTypeId")
    private Integer contentTypeId;

    @Column(name="name",length = 20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
