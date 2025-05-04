package com.example.ebookyoop.model;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private String coverPage;

    public Book(){}

    public Book(String title,String author,String genre, String isbn,String coverPage){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.coverPage = coverPage;
    }

    // Encapsulation — Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCoverPage(String coverPage){
        this.coverPage = coverPage;
    }

    public String getCoverPage(){
        return coverPage;
    }

    public String getLine(){
        return title + "," + author + "," + genre + "," + isbn + "," + coverPage;
    }
}
