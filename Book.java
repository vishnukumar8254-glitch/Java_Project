package Library_Management;

import java.time.LocalDate;

public class Book {

    int bookId;
    String bookName;
    String author;
    String category;

    boolean isAvailable;

    String studentId;
    String studentName;

    LocalDate issueDate;
    LocalDate dueDate;

    // Constructor
    public Book(int bookId, String bookName,
                String author, String category) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;

        this.isAvailable = true;
    }

    // Display Book Details
    public void displayBook() {

        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Available: " + isAvailable);

        System.out.println("---------------------------");
    }
}
