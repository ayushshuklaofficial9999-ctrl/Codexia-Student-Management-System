
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CODEXIA =====");
            System.out.println("STUDENT MANAGEMENT SYSTEM");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Codexia!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

    static void addStudent() {

        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, course));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Course: " + s.course);
            System.out.println("----------------");
        }
    }

    static void searchStudent() {

        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found!");
                System.out.println("Name: " + s.name);
                System.out.println("Course: " + s.course);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void editStudent() {

        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {

            if (s.id == id) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {

            if (s.id == id) {
                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }
}
