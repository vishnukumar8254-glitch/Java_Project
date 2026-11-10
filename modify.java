package Library_Management;
import java.util.*;
public class modify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Create Librarian Object
        Librarian librarian = new Librarian(sc);

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Book Availability");
            System.out.println("7. Fine Calculator");
            System.out.println("8. Due Date Reminder");
            System.out.println("9. View Issued Books");
            System.out.println("10. Generate Reports");
            System.out.println("11. Exit");

            System.out.println("Enter Your Choice:");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Number!");
                choice = 0;
            }

            switch (choice) {

                case 1:
                    librarian.addBook();
                    break;

                case 2:
                    librarian.viewBooks();
                    break;

                case 3:
                    librarian.searchBook();
                    break;

                case 4:
                    librarian.issueBook();
                    break;

                case 5:
                    librarian.returnBook();
                    break;

                case 6:
                    librarian.bookAvailability();
                    break;

                case 7:
                    librarian.fineCalculator();
                    break;

                case 8:
                    librarian.dueDateReminder();
                    break;

                case 9:
                    librarian.viewIssuedBooks();
                    break;

                case 10:
                    librarian.generateReports();
                    break;

                case 11:
                    System.out.println(
                        "Thank You For Using Library Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();

	}
}
	 
