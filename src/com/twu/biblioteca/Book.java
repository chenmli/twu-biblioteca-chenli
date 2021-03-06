package com.twu.biblioteca;

// This is the book class that contains the information of book name, author name , and year of publish
public class Book extends LibraryItem{
    private String bookName;
    private String bookAuthor;
    private String bookPublishedYear;

    public Book(String bookName)
    {
        super();
        this.bookName = bookName;
        this.bookAuthor = "Placeholder";
        this.bookPublishedYear = "Placeholder";
    }

    public Book(String bookName, String bookAuthor, String bookPublishedYear) {
        super();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublishedYear = bookPublishedYear;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublishedYear() {
        return bookPublishedYear;
    }

    public void setBookPublishedYear(String bookPublishedYear) {
        this.bookPublishedYear = bookPublishedYear;
    }

    @Override
    public String toString() {
        return this.getBookName()+"\t"+this.getBookAuthor()+"\t"+this.getBookPublishedYear()+"\t"+this.getId();
    }
}
