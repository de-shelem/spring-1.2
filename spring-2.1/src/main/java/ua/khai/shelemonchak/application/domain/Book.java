package ua.khai.shelemonchak.application.domain;

public class Book {
    public int id;
    public String name;
    public String author;

    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String genre;


    public Book(int id, String name, String author, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }




}
