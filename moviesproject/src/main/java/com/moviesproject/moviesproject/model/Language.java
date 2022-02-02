package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Language")
@Entity
@NoArgsConstructor
@Data
public class Language {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="languageId",insertable = false,updatable = false)
    private Integer languageId;

    @Column(name="name",length = 100)
    private String name;

    @Column(name="code",length = 10)
    private String code ;

    public Language(Integer languageId, String name, String code) {
        this.languageId = languageId;
        this.name = name;
        this.code = code;
    }
}
