package br.com.syonet;

import java.util.Objects;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Book extends PanacheEntity {
    public String title;
    public String author;
    public int year;

    public Book() {}

    public Book(String title, String author, int year) {
        this.title = Objects.requireNonNull(title, "Title não pode ser nulo!");
        this.author = Objects.requireNonNull(author, "Author não pode ser nulo!");
        this.year = Objects.requireNonNull(year, "Year não pode ser nulo!");
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
    }
}
