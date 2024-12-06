package studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Add a new student
    public void addStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student score: ");
        float score = Float.parseFloat(scanner.nextLine());

        Student student = new Student(id, name, score);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    // Update student information
    public void updateStudent() {
        System.out.println("Enter the student ID to update: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("Enter new name: ");
            student.setName(scanner.nextLine());
            System.out.println("Enter new score: ");
            student.setScore(Float.parseFloat(scanner.nextLine()));
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // Delete a student
    public void deleteStudent() {
        System.out.println("Enter the student ID to delete: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);

        if (student != null) {
            studentList.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Sort students by score using the Merge Sort algorithm
    public void sortStudentsByScore() {
        mergeSort(studentList, 0, studentList.size() - 1);
        System.out.println("Students sorted by score successfully.");
        displayStudentList();
    }

    // Display the student list
    public void displayStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            for (Student student : studentList) {
                student.displayInfo();
            }
        }
    }

    // Method to use Merge Sort to sort students
    private void mergeSort(ArrayList<Student> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(ArrayList<Student> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Student> leftList = new ArrayList<>(n1);
        ArrayList<Student> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int i = 0; i < n2; i++) {
            rightList.add(list.get(mid + 1 + i));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getScore() <= rightList.get(j).getScore()) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    // Menu for student management
    public void menu() {
        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT ====");
            System.out.println("1. Add student");
            System.out.println("2. Display student list");
            System.out.println("3. Update student information");
            System.out.println("4. Delete student");
            System.out.println("5. Sort students by score");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudentList();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> sortStudentsByScore();
                case 6 -> {
                    System.out.println("Exiting the program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.menu();
    }
}


