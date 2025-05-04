package com.example.ebookyoop.model;

public class PrintedBook extends Book{
    private int bookCount;

    public PrintedBook(String title,String author,String genre,String isbn,String coverPage,int bookCount){
        super(title, author, genre, isbn,coverPage);
        this.bookCount = bookCount;
    }

    public void setBookCount(int count){
        this.bookCount = count;
    }

    public int getBookCount(){
        return bookCount;
    }

    @Override
    public String getLine(){
        return  super.getLine() + "," + bookCount;
    }
}
