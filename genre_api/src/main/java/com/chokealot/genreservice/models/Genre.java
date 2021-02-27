package com.chokealot.genreservice.models;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String genre;

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Genre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
