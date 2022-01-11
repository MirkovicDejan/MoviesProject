package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ContentComment")
@NoArgsConstructor
@Data
public class ContentComment {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentId",insertable = false,updatable = false)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="contentId")
    private Content content;

    @Column(name="comment",length = 200)
    private String comment;

    @Column(name="replayId")
    private Integer replayId;


}
