package assessment;

import java.util.*;

class BookStore {
    private int bookId;
    private String bookName;

    public BookStore(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Book Name: " + bookName;
    }
}

public class Q41 {
    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();
        books.add(new BookStore(103, "Data Structures"));
        books.add(new BookStore(101, "Java Programming"));
        books.add(new BookStore(102, "Algorithms"));
        books.add(new BookStore(104, "Java Programming"));

        System.out.println("Sorted by Book Name:");
        books.sort(Comparator.comparing(BookStore::getBookName));
        books.forEach(System.out::println);

        System.out.println("\nSorted by Book ID:");
        books.sort(Comparator.comparingInt(BookStore::getBookId));
        books.forEach(System.out::println);
    }
}
