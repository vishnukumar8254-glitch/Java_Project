package Online_Voting;
import java.util.*;
public class Main {

	static Scanner sc = new Scanner(System.in);

    // Arrays to store objects
    static User[] users = new User[100];

    static Candidate[] candidates = new Candidate[100];

    static int userCount = 0;
    static int candidateCount = 0;

    // Register Student
    static void registerStudent() {

        System.out.println("\n--- Student Registration ---");

        if (userCount >= users.length) {

            System.out.println("User Storage is Full!");
            return;
        }

        System.out.print("Enter User ID: ");
        int id = Integer.parseInt(sc.nextLine());

        // Check duplicate ID
        for (int i = 0; i < userCount; i++) {

            if (users[i].userId == id) {

                System.out.println("User ID Already Exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        // Creating User Object
        User user = new User(id, name, password, department);

        users[userCount] = user;

        userCount++;

        System.out.println("Student Registered Successfully!");
    }

    // Display Students
    static void displayStudents() {

        System.out.println("\n--- Registered Students ---");

        if (userCount == 0) {

            System.out.println("No Students Registered!");
            return;
        }

        for (int i = 0; i < userCount; i++) {

            users[i].displayUser();
        }
    }

    // Add Candidate
    static void addCandidate() {

        System.out.println("\n--- Add Candidate ---");

        if (candidateCount >= candidates.length) {

            System.out.println("Candidate Storage is Full!");
            return;
        }

        System.out.print("Enter Candidate ID: ");
        int id = Integer.parseInt(sc.nextLine());

        // Check duplicate candidate ID
        for (int i = 0; i < candidateCount; i++) {

            if (candidates[i].candidateId == id) {

                System.out.println("Candidate ID Already Exists!");
                return;
            }
        }

        System.out.print("Enter Candidate Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Party Name: ");
        String party = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Candidate candidate =
                new Candidate(id, name, party, department);

        candidates[candidateCount] = candidate;

        candidateCount++;

        System.out.println("Candidate Added Successfully!");
    }

    // Display Candidates
    static void displayCandidates() {

        System.out.println("\n--- Candidate List ---");

        if (candidateCount == 0) {

            System.out.println("No Candidates Available!");
            return;
        }

        for (int i = 0; i < candidateCount; i++) {

            candidates[i].displayCandidate();
        }
    }

    // Search Candidate by ID
    static void searchCandidate(int id) {

        boolean found = false;

        for (int i = 0; i < candidateCount; i++) {

            if (candidates[i].candidateId == id) {

                System.out.println("Candidate Found!");

                candidates[i].displayCandidate();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println("Candidate Not Found!");
        }
    }

    // Search Candidate by Name - Method Overloading
    static void searchCandidate(String name) {

        boolean found = false;

        for (int i = 0; i < candidateCount; i++) {

            if (candidates[i].candidateName.equalsIgnoreCase(name)) {

                System.out.println("Candidate Found!");

                candidates[i].displayCandidate();

                found = true;
            }
        }

        if (!found) {

            System.out.println("Candidate Not Found!");
        }
    }

    // Search Menu
    static void searchMenu() {

        System.out.println("\n--- Search Candidate ---");

        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");

        System.out.print("Enter Choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:

                System.out.print("Enter Candidate ID: ");

                int id = Integer.parseInt(sc.nextLine());

                searchCandidate(id);

                break;

            case 2:

                System.out.print("Enter Candidate Name: ");

                String name = sc.nextLine();

                searchCandidate(name);

                break;

            default:

                System.out.println("Invalid Choice!");
        }
    }
    
 // Cast Vote
    static void castVote() {

        System.out.println("\n--- Cast Vote ---");

        System.out.print("Enter Student ID: ");
        int userId = Integer.parseInt(sc.nextLine());

        User user = null;

        // Find Student
        for (int i = 0; i < userCount; i++) {

            if (users[i].userId == userId) {

                user = users[i];
                break;
            }
        }

        if (user == null) {

            System.out.println("Student Not Found!");
            return;
        }

        // Check whether student has already voted
        if (user.hasVoted) {

            System.out.println("You Have Already Voted!");
            return;
        }

        System.out.print("Enter Candidate ID: ");
        int candidateId = Integer.parseInt(sc.nextLine());

        Candidate candidate = null;

        // Find Candidate
        for (int i = 0; i < candidateCount; i++) {

            if (candidates[i].candidateId == candidateId) {

                candidate = candidates[i];
                break;
            }
        }

        if (candidate == null) {

            System.out.println("Candidate Not Found!");
            return;
        }

        // Increase Candidate Vote Count
        candidate.totalVotes++;

        // Update Voting Status
        user.hasVoted = true;

        System.out.println("Vote Submitted Successfully!");

        System.out.println("Your Voting Status: " + user.hasVoted);
    }

    // Demonstrate Copy Constructor
    static void copyConstructorDemo() {

        if (userCount == 0) {

            System.out.println("Register a Student First!");
            return;
        }

        User copiedUser = new User(users[0]);

        System.out.println("\n--- Copied Student Details ---");

        copiedUser.displayUser();

        System.out.println("Copy Constructor Executed Successfully!");
    }
    
    

    // Main Method
    public static void main(String[] args) {

        int choice = 0;

        do {

            System.out.println("\n==================================");
            System.out.println("       ONLINE VOTING SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Register Student");
            System.out.println("2. Display Students");
            System.out.println("3. Add Candidate");
            System.out.println("4. Display Candidates");
            System.out.println("5. Search Candidate");
            System.out.println("6. Copy Constructor Demo");
            System.out.println("7. Caste Vote");
            System.out.println("8. Exit");

            System.out.println("==================================");

            try {

                System.out.print("Enter Your Choice: ");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        registerStudent();

                        break;

                    case 2:

                        displayStudents();

                        break;

                    case 3:

                        addCandidate();

                        break;

                    case 4:

                        displayCandidates();

                        break;

                    case 5:

                        searchMenu();

                        break;

                    case 6:

                        copyConstructorDemo();

                        break;
                        
                    case 7:

                        castVote();

                        break;

                    case 8:

                        System.out.println(
                                "Thank You for Using Online Voting System!"
                        );

                        break;

                    default:

                        System.out.println("Invalid Choice!");

                        break;
                }

            } catch (NumberFormatException e) {

                System.out.println("Please Enter Valid Numbers!");

            }

        } while (choice != 8);

        sc.close();
    }

}
