package com.twu.biblioteca;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    static BibliotecaApp bibliotecaApp;
    static List<Book> expectedBookList;
    @BeforeClass
    //generating expected list and actual app
    public static void setup() {
        bibliotecaApp = new BibliotecaApp(new ArrayList<Book>());
        expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("Childhood of TWER","TWER","2000"));
        expectedBookList.add(new Book("Adulthood of TWER","TWER","2000"));
        expectedBookList.add(new Book("Neighborhood of TWER","TWER","2000"));
    }

    @Test
    //test book name
    public void shouldTheBookListDisplayBookName() {
        System.out.println("Running Book Name Test");
        for(int i = 0; i < bibliotecaApp.getBookList().size();i++)
        {
            assertEquals(expectedBookList.get(i).getBookName(),bibliotecaApp.getBookList().get(i).getBookName());
        }

    }
    @Test
    //test book author and year
    public void shouldTheBookListDisplayBookAuthorAndYear() {
        System.out.println("Running Author Name and Published Year Test");
        for(int i = 0; i < bibliotecaApp.getBookList().size();i++)
        {
            assertEquals(expectedBookList.get(i).getBookAuthor(),bibliotecaApp.getBookList().get(i).getBookAuthor());
            assertEquals(expectedBookList.get(i).getBookPublishedYear(),bibliotecaApp.getBookList().get(i).getBookPublishedYear());
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
   // @Test
    //public void shouldThe

}
