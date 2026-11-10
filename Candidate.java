package Online_Voting;

public class Candidate {
	
	int candidateId;
    String candidateName;
    String partyName;
    String department;

    int totalVotes;

    // Static variable
    static String electionName = "College Election 2026";

    // Final variable
    final int maximumVotesAllowed = 1000;

    // Constructor 1
    Candidate(int candidateId, String candidateName) {

        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyName = "Independent";
        this.department = "General";
        this.totalVotes = 1;
    }

    // Constructor 2 - Constructor Overloading
    Candidate(int candidateId, String candidateName,
              String partyName, String department) {

        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyName = partyName;
        this.department = department;
        this.totalVotes = 1;
    }

    // Constructor 3 - Copy Constructor
    Candidate(Candidate candidate) {

        this.candidateId = candidate.candidateId;
        this.candidateName = candidate.candidateName;
        this.partyName = candidate.partyName;
        this.department = candidate.department;
        this.totalVotes = candidate.totalVotes;
    }

    // Display Candidate Details
    void displayCandidate() {

        System.out.println("Candidate ID: " + candidateId);
        System.out.println("Candidate Name: " + candidateName);
        System.out.println("Party Name: " + partyName);
        System.out.println("Department: " + department);
        System.out.println("Total Votes: " + totalVotes);

        System.out.println("Election: " + electionName);

        System.out.println("-------------------------");
    }

    // Method Overloading 1
    void updateParty(String partyName) {

        this.partyName = partyName;
    }

    // Method Overloading 2
    void updateParty(String partyName, String department) {

        this.partyName = partyName;
        this.department = department;
    }

    // toString method
    public String toString() {

        return "Candidate ID: " + candidateId
                + ", Name: " + candidateName
                + ", Party: " + partyName;
    }

}
