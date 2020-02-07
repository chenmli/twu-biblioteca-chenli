package com.twu.biblioteca;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private List<Book> bookList;

    public BibliotecaApp(List<Book> bookList)
    {
        this.bookList = bookList;
        this.bookList.add(new Book("Childhood of TWER","TWER","2000"));
        this.bookList.add(new Book("Adulthood of TWER","TWER","2000"));
        this.bookList.add(new Book("Neighborhood of TWER","TWER","2000"));

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
            System.out.println(book.getBookName()+"\t"+book.getBookAuthor()+"\t"+book.getBookPublishedYear());
        }
    }
    // Run Menu
    public String menuControls(List<String> menuList)
    {
        Scanner userInputScanner = new Scanner(System.in);
        String userChoice = "";
        displayMenu(menuList);
        userChoice = userInputScanner.nextLine().trim();
        return userChoice;
    }
    //Displays Menu
    public void displayMenu(List<String> menuList)
    {
        System.out.println("Main Menu:");
        for(int i = 0; i < menuList.size();i++)
        {
            System.out.println((i+1)+". "+menuList.get(i));
        }
        System.out.print("Please make a choice: ");
    }
    public static void main(String[] args) {
        List<String> menuList = new ArrayList<String>();
        menuList.add("List of Books");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<Book>());
        bibliotecaApp.menuControls(menuList);

    }

}
