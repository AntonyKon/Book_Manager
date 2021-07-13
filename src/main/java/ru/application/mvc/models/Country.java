package ru.application.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @Column(name="country_name")
    private String name;

    @OneToMany(mappedBy = "country")
    List<Author> authors = new ArrayList<>();
}
