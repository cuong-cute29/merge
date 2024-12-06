final class Student {
    String studentId;
    String name;
    double marks;
    String rank;

    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.rank = assignRank();
    }

    public String assignRank() {
        if (marks >= 0 && marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid";
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10.2f %-10s", studentId, name, marks, rank);
    }
}
