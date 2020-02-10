package com.twu.biblioteca;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.plugin.liveconnect.LiveConnect;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {
    static BibliotecaApp bibliotecaApp;
    static List<LibraryItem> expectedBookList;
    @BeforeClass
    //generating expected list and actual app
    public static void setup() {
        bibliotecaApp = new BibliotecaApp(new ArrayList<LibraryItem>());
        expectedBookList = new ArrayList<LibraryItem>();
        expectedBookList.add(new Book("Childhood of TWER","TWER","2000"));
        expectedBookList.add(new Book("Adulthood of TWER","TWER","2000"));
        expectedBookList.add(new Book("Neighborhood of TWER","TWER","2000"));
    }

    @Test
    //test book name
    public void shouldTheBookListDisplayBookName() {
        System.out.println("Running Book Name Test");
        Book tempExpected;
        Book tempActual;
        for(int i = 0; i < bibliotecaApp.getBookList().size();i++)
        {
            tempExpected = (Book) expectedBookList.get(i);
            tempActual = (Book) bibliotecaApp.getBookList().get(i);
            assertEquals(tempExpected.getBookName(),tempActual.getBookName());
        }

    }
    @Test
    //test book author and year
    public void shouldTheBookListDisplayBookAuthorAndYear() {
        System.out.println("Running Author Name and Published Year Test");
        Book tempExpected;
        Book tempActual;
        for(int i = 0; i < bibliotecaApp.getBookList().size();i++)
        {
            tempExpected = (Book) expectedBookList.get(i);
            tempActual = (Book) bibliotecaApp.getBookList().get(i);
            assertEquals(tempExpected.getBookAuthor(),tempActual.getBookAuthor());
            assertEquals(tempExpected.getBookPublishedYear(),tempActual.getBookPublishedYear());
        }

    }
    @Test
    public void shouldTheUserInputIsCorrect()
    {

    }
    @Test
    public void shouldTheUserInputIsInvalid()
    {

    }
   @Test
    public void shouldTheBookBeCheckOut()
    {
        Book testBook = new Book("Random is Key");
        testBook.checkout();
        assertTrue(testBook.isCheckedOut());
    }
    @Test
    public void shouldTheUserViewOnlyAvailableList()
    {
        System.out.println("Running test- available list");
       expectedBookList.get(0).isCheckedOut();

       List<LibraryItem> availableList = bibliotecaApp.updateAvailableList(expectedBookList);

       for(LibraryItem libraryItem: availableList)
       {
           assertTrue(!libraryItem.isCheckedOut());
       }

    }


}
