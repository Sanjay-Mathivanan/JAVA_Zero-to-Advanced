package Collections.Maps.HashMap.StudentRecordManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean exit = false;

        while (!exit) {

            printMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    Student student =
                            new Student(id, name, age, department, marks);

                    manager.addStudent(student);

                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    manager.searchStudent(scanner.nextInt());

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    department = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextDouble();

                    manager.updateStudent(
                            id,
                            name,
                            age,
                            department,
                            marks);

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    manager.deleteStudent(scanner.nextInt());

                    break;

                case 5:

                    manager.displayStudents();

                    break;

                case 6:

                    manager.totalStudents();

                    break;

                case 7:

                    System.out.print("Enter Student ID: ");
                    manager.checkStudent(scanner.nextInt());

                    break;

                case 0:

                    exit = true;
                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice.");
            }
        }

        scanner.close();
    }

    public static void printMenu() {

        System.out.println("\n========== STUDENT RECORD MANAGEMENT ==========");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Total Students");
        System.out.println("7. Check Student Exists");
        System.out.println("0. Exit");
    }
}
