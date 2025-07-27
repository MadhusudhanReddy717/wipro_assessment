package assessment;

import java.util.*;

// Generic Library class
class Library<T> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Non-generic version
class MediaLibrary {
    private List<Object> items;

    public MediaLibrary() {
        items = new ArrayList<>();
    }

    public void addItem(Object item) {
        items.add(item);
    }

    public List<Object> getItems() {
        return items;
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    public String toString() {
        return "Book: " + title;
    }
}

class Video {
    String title;

    public Video(String title) {
        this.title = title;
    }

    public String toString() {
        return "Video: " + title;
    }
}

class Newspaper {
    String name;

    public Newspaper(String name) {
        this.name = name;
    }

    public String toString() {
        return "Newspaper: " + name;
    }
}

public class Q39 {
    public static void main(String[] args) {
        // Generic usage
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.addItem(new Book("Java Basics"));
        bookLibrary.addItem(new Book("OOP Concepts"));

        System.out.println("Generic Book Library:");
        for (Book b : bookLibrary.getItems()) {
            System.out.println(b);
        }

        // Non-generic usage
        MediaLibrary mediaLibrary = new MediaLibrary();
        mediaLibrary.addItem(new Book("DSA"));
        mediaLibrary.addItem(new Video("Java Tutorial"));
        mediaLibrary.addItem(new Newspaper("The Times"));

        System.out.println("\nNon-Generic Media Library:");
        for (Object obj : mediaLibrary.getItems()) {
            System.out.println(obj);
        }
    }
}
