package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private List<LibraryItem> bookList;
    private List<LibraryItem> availableList;

    public BibliotecaApp(List<LibraryItem> bookList)
    {
        this.bookList = bookList;
        this.bookList.add(new Book("Childhood of TWER","TWER","2000"));
        this.bookList.add(new Book("Adulthood of TWER","TWER","2000"));
        this.bookList.add(new Book("Neighborhood of TWER","TWER","2000"));

    }

    public List<LibraryItem> getBookList() {
        return bookList;
    }

    public void setBookList(List<LibraryItem> bookList) {
        this.bookList = bookList;
    }

    // Displays Welcome Message
    public void displayWelcomeMessage()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    public void exit()
    {
        System.exit(0);
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
                userInputInt = menuControls(menuList);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Please select a valid option");
            userInputInt = menuControls(menuList);
        }
        return userInputInt;
    }

    //Displays Menu
    public void displayMenu(List<String> menuList)
    {
        for(int i=0; i < menuList.size();i++)
        {
            System.out.println((i+1)+". "+menuList.get(i));
        }
        System.out.print("Please make a choice: ");
    }
    // Menu Options Method: Book List
    public void displayBookList(List<LibraryItem> bookList)
    {
        for(int i = 0;i<bookList.size();i++)
        {
            System.out.println((i+1)+". "+((Book)bookList.get(i)).toString());
        }
    }
    // Menu Options Method: Book List

    // get a available list
    public List<LibraryItem> updateAvailableList(List<LibraryItem> list)
    {
        List<LibraryItem> availableList = new ArrayList<LibraryItem>();
        for(LibraryItem libraryItem: list)
        {
            if(!libraryItem.isCheckedOut())
                availableList.add(libraryItem);
        }
        return availableList;
    }

    //Run the main menu
    public void runMainMenu()
    {
        List<String> mainMenuList = new ArrayList<String>();
        mainMenuList.add("List of Books");
        mainMenuList.add("Exit");
        int input;
        boolean flag = true;
        displayWelcomeMessage();
        while(flag)
        {
            input = menuControls(mainMenuList);
            switch(input)
            {
                case 1 : runBookMenu();
                        break;
                case 2 : exit();
                        break;
                default:
                    runMainMenu();
            }
        }
    }
    //Run the main menu
    public void runBookMenu()
    {
        List<String> bookMenuList = new ArrayList<String>();
        bookMenuList.add("Show Available List");
        bookMenuList.add("Exit");
        int input;
        boolean flag = true;
        displayBookList((ArrayList<LibraryItem>) getBookList());
        while(flag)
        {
            input = menuControls(bookMenuList);
            switch(input)
            {
                case 1 : runCheckOutMenu();
                             break;
                case 2 : exit();
                            break;
                default:
                    runBookMenu();
            }
        }
    }
    public void runCheckOutMenu()
    {
        Scanner userInput = new Scanner(System.in);
        int userInputInt=Integer.MAX_VALUE;
        boolean bookFlag = false;
        String userRawInput="";
        this.availableList=updateAvailableList(bookList);

        while(true)
        {
            displayBookList(availableList);
            System.out.println((availableList.size()+1)+". Exit");
            System.out.println("Please enter the book id to check out or exit:");
            userRawInput = userInput.nextLine().trim();
            try
            {

                userInputInt = Integer.parseInt(userRawInput);
                if(userInputInt == availableList.size()+1)
                {
                    exit();
                    break;
                }
                for(LibraryItem item : availableList)
                {
                    if(item.getId().equals(String.valueOf(userInputInt)))
                    {
                        for(int i = 0; i< bookList.size();i++)
                        {
                            if(bookList.get(i).getId().equals(String.valueOf(userInputInt)))
                            {
                                bookList.get(i).checkout();
                                this.availableList= updateAvailableList(bookList);
                                System.out.println("Thank you! Enjoy your book!");
                            }
                        }
                        bookFlag = true;
                    }
                }
                if(bookFlag==false)
                {
                    System.out.println("Sorry! This Book is not available!");
                }
                bookFlag = false;
            }
            catch(Exception ex)
            {
                System.out.println("Please select a valid option");
                runCheckOutMenu();
            }


        }
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<LibraryItem>());
        bibliotecaApp.runMainMenu();



    }

}
