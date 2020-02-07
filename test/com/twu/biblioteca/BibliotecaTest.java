package com.twu.biblioteca;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    static BibliotecaApp bibliotecaApp;
    static List<Book> expectedBookList;
    @BeforeClass
    public static void setup() {
        bibliotecaApp = new BibliotecaApp(new ArrayList<Book>());
        expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("Childhood of Logan"));
        expectedBookList.add(new Book("Adulthood of Aaron"));
        expectedBookList.add(new Book("Neighborhood of Paris"));
    }

    @Test
    public void shouldTheBookListDisplayAccurateInfo() {
        for(int i = 0; i < bibliotecaApp.getBookList().size();i++)
        {
            assertEquals(expectedBookList.get(i).getBookName(),bibliotecaApp.getBookList().get(i).getBookName());
        }


    }
}
