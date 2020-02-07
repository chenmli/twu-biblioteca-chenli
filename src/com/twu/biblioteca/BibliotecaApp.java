package com.twu.biblioteca;

import java.util.*;

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

    // Run Menu
    public int menuControls(List<String> menuList)
    {
        Scanner userInputScanner = new Scanner(System.in);
        String userRawInput = "";
        Integer userInputInt= Integer.MAX_VALUE;
        displayMenu(menuList);
        userRawInput = userInputScanner.nextLine().trim();
        //validations
        try
        {
            userInputInt = Integer.parseInt(userRawInput);
            if(userInputInt<0 || userInputInt > menuList.size())
            {
                System.out.println("Please select a valid option");
                menuControls(menuList);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Please select a valid option");
            menuControls(menuList);
        }
        return userInputInt;
    }

    //Displays Menu
    public void displayMenu(List<String> menuList)
    {
        System.out.println("Main Menu:");
        for(int i=0; i < menuList.size();i++)
        {
            System.out.println((i+1)+". "+menuList.get(i));
        }
        System.out.print("Please make a choice: ");
    }
    // Menu Options Method: Book List
    public void displayBookList()
    {
        for(int i = 0;i<bookList.size();i++)
        {
            System.out.println((i+1)+". "+bookList.get(i).toString());
        }
    }
    public static void main(String[] args) {
        boolean flag = true;
        List<String> mainMenuList = new ArrayList<String>();
        mainMenuList.add("List of Books");
        mainMenuList.add("Exit");

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<Book>());
        while(flag)
        {
            int input = bibliotecaApp.menuControls(mainMenuList);
            switch(input)
            {
                case 1 : bibliotecaApp.displayBookList();
                         break;
                case 2 : flag = false;

                        break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }



    }

}
