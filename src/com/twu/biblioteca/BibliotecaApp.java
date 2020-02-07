package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList;

    public BibliotecaApp(List<Book> bookList)
    {
        this.bookList = bookList;
        this.bookList.add(new Book("Childhood of Logan"));
        this.bookList.add(new Book("Adulthood of Aaron"));
        this.bookList.add(new Book("Neighborhood of Paris"));

    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    // Displays Welcome Message
    public void displayWelcomeMessage()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    // Displays Booklist
    public void displayBookList()
    {

        for (Book book:bookList) {
            System.out.println(book.getBookName());
        }
    }
    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<Book>());
        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayBookList();

    }

}
