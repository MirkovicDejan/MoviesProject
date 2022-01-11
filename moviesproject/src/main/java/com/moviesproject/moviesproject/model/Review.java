package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Review")
@NoArgsConstructor
@Data
public class Review {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="reviewId",insertable = false,updatable = false)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="contentId")
    private Content content;

    @Column(name="rating")
    private Integer rating;

    @Column(name="favourite")
    private boolean favourite;

}
