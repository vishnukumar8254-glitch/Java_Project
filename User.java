package Online_Voting;

public class User {
	
	// Variables and data types
    int userId;
    String userName;
    String password;
    String department;

    boolean hasVoted;

    // Static variable
    static String collegeName = "Engineering College";

    // Final variable
    final String userType = "Student";

    // Constructor 1
    User(int userId, String userName, String password) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.department = "Not Assigned";
        this.hasVoted = false;
    }

    // Constructor 2 - Constructor Overloading
    User(int userId, String userName,
         String password, String department) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.hasVoted = false;
    }

    // Constructor 3 - Copy Constructor
    User(User user) {

        this.userId = user.userId;
        this.userName = user.userName;
        this.password = user.password;
        this.department = user.department;
        this.hasVoted = user.hasVoted;
    }

    // Method 1 - Display User
    void displayUser() {

        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Department: " + department);
        System.out.println("User Type: " + userType);
        System.out.println("College: " + collegeName);
        System.out.println("Has Voted: " + hasVoted);

        System.out.println("-------------------------");
    }

    // Method Overloading 1
    void updateDepartment(String department) {

        this.department = department;
    }

    // Method Overloading 2
    void updateDepartment(String department, String college) {

        this.department = department;
        collegeName = college;
    }

    // toString method
    public String toString() {

        return "User ID: " + userId
                + ", Name: " + userName
                + ", Department: " + department;
    }

}
