package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publish_year")
    private LocalDate publishYear; //
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "visible")
    private Boolean visible;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<StudentBookEntity> bookSet;
}
