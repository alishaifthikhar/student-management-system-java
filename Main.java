import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    int age;
    String grade;

    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }
}

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int totalStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    updateStudentInformation(scanner);
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(name, id, age, grade));
        totalStudents++;
        System.out.println("Student added successfully!");
    }

    private static void updateStudentInformation(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student ID not found!");
            return;
        }

        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new student grade: ");
        String grade = scanner.nextLine();

        student.name = name;
        student.age = age;
        student.grade = grade;
        System.out.println("Student information updated successfully!");
    }

    private static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter student ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student ID not found!");
            return;
        }

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + student.name);
        System.out.println("ID: " + student.id);
        System.out.println("Age: " + student.age);
        System.out.println("Grade: " + student.grade);
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }
}
