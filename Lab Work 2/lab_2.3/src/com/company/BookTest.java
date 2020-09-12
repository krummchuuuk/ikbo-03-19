package com.company;

class Book {
    private String author;
    private String title;
    private int year;

    Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }
    public void set_author(String author) {
        this.author = author;
    }
    public void set_title(String title) {
        this.title = title;
    }
    public void set_year(int year) {
        this.year = year;
    }

    public String get_author() {
        return author;
    }
    public String get_title() {
        return title;
    }
    public int get_year() {
        return year;
    }
}

public class BookTest {

    public static void main(String[] args) {
	Book new_book = new Book("Джон Грин", "Виноваты звезды", 2008);
	new_book.set_title("Бумажные города");
	System.out.print(new_book.get_author()+" написал "+new_book.get_title()+" в "+new_book.get_year());
    }
}
