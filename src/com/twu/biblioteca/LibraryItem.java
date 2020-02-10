package com.twu.biblioteca;

public class LibraryItem {
    private static int count = 100;
    private String id;
    private boolean isCheckedOut;

    public LibraryItem()
    {
        this.count++;
        this.id = count+"";
        this.isCheckedOut= false;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void checkout()
    {
        this.isCheckedOut = true;
    }
    public void returnItem()
    {
        this.isCheckedOut = false;
    }
}
