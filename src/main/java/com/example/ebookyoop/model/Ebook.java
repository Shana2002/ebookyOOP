package com.example.ebookyoop.model;

public class Ebook extends Book{
    private String fileSize;
    private String link;

    public Ebook(String title,String author,String genre,String isbn,String coverPage,String fileSize,String link){
        super(title, author, genre, isbn,coverPage);
        this.fileSize = fileSize;
        this.link = link;
    }

    public String getFileSize(){
        return  fileSize;
    }

    public void setFileSize(String fileSize){
        this.fileSize = fileSize;
    }

    public String getLink(){
        return  link;
    }

    public void setLink(){
        this.link = link;
    }

    @Override
    public String getLine(){
        return super.getLine() + "," + fileSize + "," + link;
    }
}
