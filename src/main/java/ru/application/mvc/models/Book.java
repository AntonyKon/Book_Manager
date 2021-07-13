package ru.application.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    private String plot;

    @Column(name = "publication_year")
    private int publicationYear;

    private int visits;
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Author> authors = new ArrayList<>();
}
