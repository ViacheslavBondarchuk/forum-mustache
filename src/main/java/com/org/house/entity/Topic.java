package com.org.house.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
