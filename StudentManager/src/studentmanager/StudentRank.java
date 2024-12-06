package studentmanager;

public class StudentRank {

    // Method to return rank based on score
    public static String getRankByScore(float score) {
        if (score < 5.0) return "Fail";
        else if (score < 6.5) return "Average";
        else if (score < 7.5) return "Good";
        else if (score < 9.0) return "Very Good";
        else return "Excellent";
    }
}


