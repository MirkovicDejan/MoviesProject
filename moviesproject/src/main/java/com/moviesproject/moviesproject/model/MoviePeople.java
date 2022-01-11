package com.moviesproject.moviesproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MoviePeople")
@NoArgsConstructor
@Data
public class MoviePeople {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="moviePeopleId",insertable = false,updatable = false)
    private Integer moviePeopleID;

    @Column(name="firstName",length = 20)
    private  String firstName;

    @Column(name="lastName",length = 20)
    private  String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="brithDate")
    private Date brithDate;

    @Column(name="gender",length = 1)
    private char  gender;
}
