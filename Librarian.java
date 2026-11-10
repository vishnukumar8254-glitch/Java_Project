package Library_Management;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
	import java.time.LocalDate;
	import java.time.temporal.ChronoUnit;

	public class Librarian {

	    Scanner sc;

	    // Store all books
	    ArrayList<Book> books = new ArrayList<>();

	    // Store issued books
	    // Key = Student ID + Book ID
	    // Value = Book Object
	    Map<String, Book> issuedBooks = new HashMap<>();

	    double totalFineCollected = 0;

	    // Fine and loan settings
	    final int LOAN_DAYS = 14;
	    final double FINE_PER_DAY = 5.0;

	    // Constructor
	    public Librarian(Scanner sc) {
	        this.sc = sc;
	    }

	    // Read Integer
	    private int readInt(String message) {

	        while (true) {
	            try {
	                System.out.println(message);
	                return Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number!");
	            }
	        }
	    }

	    // Read String
	    private String readText(String message) {

	        System.out.println(message);
	        return sc.nextLine();
	    }

	    // Find Book
	    private Book findBook(int id) {

	        for (Book b : books) {

	            if (b.bookId == id) {
	                return b;
	            }
	        }

	        return null;
	    }

	    // 1. Add Book
	    public void addBook() {

	        int id = readInt("Enter Book ID:");

	        if (findBook(id) != null) {
	            System.out.println("Book ID Already Exists!");
	            return;
	        }

	        String name = readText("Enter Book Name:");
	        String author = readText("Enter Author Name:");
	        String category = readText("Enter Category:");

	        Book b = new Book(id, name, author, category);

	        books.add(b);

	        System.out.println("Book Added Successfully!");
	    }

	    // 2. View All Books
	    public void viewBooks() {

	        if (books.isEmpty()) {
	            System.out.println("No Books Available!");
	            return;
	        }

	        for (Book b : books) {
	            b.displayBook();
	        }
	    }

	    // 3. Search Book
	    public void searchBook() {

	        int id = readInt("Enter Book ID:");

	        Book b = findBook(id);

	        if (b != null) {
	            b.displayBook();
	        } else {
	            System.out.println("Book Not Found!");
	        }
	    }

	    // 4. Issue Book
	    public void issueBook() {

	        int id = readInt("Enter Book ID:");

	        Book b = findBook(id);

	        if (b == null) {
	            System.out.println("Book Not Found!");
	            return;
	        }

	        if (!b.isAvailable) {
	            System.out.println("Book Already Issued!");
	            return;
	        }

	        String studentId = readText("Enter Student ID:");
	        String studentName = readText("Enter Student Name:");

	        String approval = readText(
	            "Librarian Approval (yes/no):"
	        );

	        if (!approval.equalsIgnoreCase("yes")) {
	            System.out.println("Book Issue Not Approved!");
	            return;
	        }

	        b.studentId = studentId;
	        b.studentName = studentName;

	        // Current Issue Date
	        b.issueDate = LocalDate.now();

	        // Due Date After 14 Days
	        b.dueDate = b.issueDate.plusDays(LOAN_DAYS);

	        b.isAvailable = false;

	        String key = studentId + "-" + id;

	        issuedBooks.put(key, b);

	        System.out.println("\nBook Issued Successfully!");

	        System.out.println("Student ID: " + studentId);
	        System.out.println("Student Name: " + studentName);
	        System.out.println("Book Name: " + b.bookName);
	        System.out.println("Issue Date: " + b.issueDate);
	        System.out.println("Due Date: " + b.dueDate);
	    }

	    // 5. Return Book
	    public void returnBook() {

	        String studentId = readText("Enter Student ID:");
	        int bookId = readInt("Enter Book ID:");

	        String key = studentId + "-" + bookId;

	        Book b = issuedBooks.get(key);

	        if (b == null) {
	            System.out.println("Issued Book Not Found!");
	            return;
	        }

	        // Current Return Date
	        LocalDate returnDate = LocalDate.now();

	        System.out.println("\n----- RETURN DETAILS -----");

	        System.out.println("Book Name: " + b.bookName);
	        System.out.println("Student Name: " + b.studentName);
	        System.out.println("Issue Date: " + b.issueDate);
	        System.out.println("Due Date: " + b.dueDate);
	        System.out.println("Return Date: " + returnDate);

	        // Calculate Late Days
	        long lateDays = ChronoUnit.DAYS.between(
	            b.dueDate, returnDate
	        );

	        double fine = 0;

	        if (lateDays > 0) {

	            fine = lateDays * FINE_PER_DAY;

	            System.out.println("Late Days: " + lateDays);
	            System.out.println("Fine Amount: Rs." + fine);

	            String payment = readText(
	                "Fine Collected? (yes/no):"
	            );

	            if (!payment.equalsIgnoreCase("yes")) {

	                System.out.println(
	                    "Collect Fine Before Returning Book!"
	                );

	                return;
	            }

	            totalFineCollected += fine;

	        } else {

	            System.out.println("No Late Days!");
	            System.out.println("Fine Amount: Rs.0");
	        }

	        // Update Book Details
	        b.isAvailable = true;

	        b.studentId = null;
	        b.studentName = null;
	        b.issueDate = null;
	        b.dueDate = null;

	        // Remove from Issued Books
	        issuedBooks.remove(key);

	        System.out.println("Book Returned Successfully!");
	    }

	    // 6. Book Availability
	    public void bookAvailability() {

	        int id = readInt("Enter Book ID:");

	        Book b = findBook(id);

	        if (b == null) {
	            System.out.println("Book Not Found!");
	        } else if (b.isAvailable) {
	            System.out.println("Book Is Available!");
	        } else {
	            System.out.println("Book Is Currently Issued!");
	        }
	    }

	    // 7. Fine Calculator
	    public void fineCalculator() {

	        int id = readInt("Enter Book ID:");

	        Book b = findBook(id);

	        if (b == null || b.isAvailable) {
	            System.out.println("No Issued Book Found!");
	            return;
	        }

	        LocalDate today = LocalDate.now();

	        long lateDays = ChronoUnit.DAYS.between(
	            b.dueDate, today
	        );

	        if (lateDays > 0) {

	            double fine = lateDays * FINE_PER_DAY;

	            System.out.println("Due Date: " + b.dueDate);
	            System.out.println("Today's Date: " + today);
	            System.out.println("Late Days: " + lateDays);
	            System.out.println("Fine Amount: Rs." + fine);

	        } else {

	            System.out.println("No Fine!");
	            System.out.println("Due Date: " + b.dueDate);
	        }
	    }

	    // 8. Due Date Reminder
	    public void dueDateReminder() {

	        LocalDate today = LocalDate.now();

	        if (issuedBooks.isEmpty()) {
	            System.out.println("No Issued Books!");
	            return;
	        }

	        System.out.println("\n----- DUE DATE REMINDERS -----");

	        for (Book b : issuedBooks.values()) {

	            System.out.println("Student: " + b.studentName);
	            System.out.println("Book: " + b.bookName);
	            System.out.println("Due Date: " + b.dueDate);

	            if (today.isAfter(b.dueDate)) {

	                long days = ChronoUnit.DAYS.between(
	                    b.dueDate, today
	                );

	                System.out.println(
	                    "OVERDUE! Late by " + days + " days"
	                );

	            } else if (today.isEqual(b.dueDate)) {

	                System.out.println("Return Today!");

	            } else {

	                long days = ChronoUnit.DAYS.between(
	                    today, b.dueDate
	                );

	                System.out.println(
	                    "Due in " + days + " days"
	                );
	            }

	            System.out.println("---------------------------");
	        }
	    }

	    // 9. View Issued Books
	    public void viewIssuedBooks() {

	        if (issuedBooks.isEmpty()) {
	            System.out.println("No Issued Books!");
	            return;
	        }

	        for (Map.Entry<String, Book> entry :
	             issuedBooks.entrySet()) {

	            Book b = entry.getValue();

	            System.out.println("Student ID: " + b.studentId);
	            System.out.println("Student Name: " + b.studentName);
	            System.out.println("Book ID: " + b.bookId);
	            System.out.println("Book Name: " + b.bookName);
	            System.out.println("Issue Date: " + b.issueDate);
	            System.out.println("Due Date: " + b.dueDate);

	            System.out.println("---------------------------");
	        }
	    }

	    // 10. Generate Reports
	    public void generateReports() {

	        int available = 0;
	        int issued = 0;

	        for (Book b : books) {

	            if (b.isAvailable) {
	                available++;
	            } else {
	                issued++;
	            }
	        }

	        System.out.println("\n----- LIBRARY REPORT -----");

	        System.out.println("Total Books: " + books.size());
	        System.out.println("Available Books: " + available);
	        System.out.println("Issued Books: " + issued);

	        System.out.println(
	            "Total Fine Collected: Rs." + totalFineCollected
	        );

	        System.out.println("---------------------------");
	    }
}
