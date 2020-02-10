package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.*;

public class BibliotecaApp {

    private List<LibraryItem> itemList;
    private List<LibraryItem> availableList;
    private List<LibraryItem> checkoutList;
    public BibliotecaApp(List<LibraryItem> bookList)
    {
        this.itemList = bookList;
        this.itemList.add(new Book("Childhood of TWER","TWER","2000"));
        this.itemList.add(new Book("Adulthood of TWER","TWER","2000"));
        this.itemList.add(new Book("Neighborhood of TWER","TWER","2000"));

    }

    public List<LibraryItem> getBookList() {
        return itemList;
    }

    public void setBookList(List<LibraryItem> bookList) {
        this.itemList = bookList;
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
    public List<LibraryItem> updateCheckOutList(List<LibraryItem> list)
    {
        List<LibraryItem> checkoutList = new ArrayList<LibraryItem>();
        for(LibraryItem libraryItem: list)
        {
            if(libraryItem.isCheckedOut())
                checkoutList.add(libraryItem);
        }
        return checkoutList;
    }
    //Run the main menu
    public void runMainMenu()
    {
        List<String> mainMenuList = new ArrayList<String>();
        mainMenuList.add("List of Books");
        mainMenuList.add("Return a Book");
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
                case 2 : runReturnBookMenu();
                         break;
                case 3 : exit();
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
        bookMenuList.add("Check Out Available Books");
        bookMenuList.add("Exit");
        int input;
        boolean flag = true;
        displayBookList(getBookList());
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
        int userInputInt;
        boolean bookFlag = false;
        String userRawInput="";
        this.availableList=updateAvailableList(itemList);

        while(true)
        {
            displayBookList(availableList);
            System.out.println((availableList.size()+1)+". Main Menu");
            System.out.println((availableList.size()+2)+". Exit");
            System.out.println("Please enter the book id to check out or exit:");
            userRawInput = userInput.nextLine().trim();
            try
            {

                userInputInt = Integer.parseInt(userRawInput);
                if(userInputInt == availableList.size()+1)
                {
                    runMainMenu();
                }
                if(userInputInt == availableList.size()+2)
                {
                    exit();
                    break;
                }
                for(LibraryItem item : availableList)
                {
                    if(item.getId().equals(String.valueOf(userInputInt)))
                    {
                        for(int i = 0; i< itemList.size();i++)
                        {
                            if(itemList.get(i).getId().equals(String.valueOf(userInputInt)))
                            {
                                itemList.get(i).checkout();
                                this.availableList= updateAvailableList(itemList);
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
    public void runReturnBookMenu() {
        Scanner userInput = new Scanner(System.in);
        int userInputInt;
        boolean bookFlag = false;
        String userRawInput = "";
        this.checkoutList = updateCheckOutList(itemList);
        while (true) {
            displayBookList(checkoutList);
            System.out.println((checkoutList.size() + 1) + ". Main Menu");
            System.out.println((checkoutList.size() + 2) + ". Exit");
            System.out.println("Please enter the book id to return or exit:");
            userRawInput = userInput.nextLine().trim();
            try {

                userInputInt = Integer.parseInt(userRawInput);
                if (userInputInt == checkoutList.size() + 1) {
                    runMainMenu();
                }
                if (userInputInt == checkoutList.size() + 2) {
                    exit();
                    break;
                }
                for (LibraryItem item : checkoutList) {
                    if (item.getId().equals(String.valueOf(userInputInt))) {
                        for (int i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getId().equals(String.valueOf(userInputInt))) {
                                itemList.get(i).returnItem();
                                this.checkoutList = updateCheckOutList(itemList);
                                System.out.println("Thank you for returning the book.");
                            }
                        }
                        bookFlag = true;
                    }
                }
                if (bookFlag == false) {
                    System.out.println("Sorry! This Book is not valid to return!");
                }
                bookFlag = false;
            } catch (Exception ex) {
                System.out.println("Please select a valid option");
                runReturnBookMenu();
            }

        }
    }
    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ArrayList<LibraryItem>());
        bibliotecaApp.runMainMenu();



    }

}
