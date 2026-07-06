package Collections.Maps.HashMap.StudentRecordManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    // HashMap to store student records
    private Map<Integer, Student> students;

    // Constructor
    public StudentManager() {
        students = new HashMap<>();
    }

    // Add Student
    public void addStudent(Student student) {

        if (students.containsKey(student.getStudentId())) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.put(student.getStudentId(), student);
        System.out.println("Student added successfully.");
    }

    // Search Student
    public void searchStudent(int studentId) {

        Student student = students.get(studentId);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Update Student
    public void updateStudent(int studentId,
                              String name,
                              int age,
                              String department,
                              double marks) {

        Student student = students.get(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }

    // Delete Student
    public void deleteStudent(int studentId) {

        if (students.remove(studentId) != null) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========\n");

        for (Map.Entry<Integer, Student> entry : students.entrySet()) {

            System.out.println(entry.getValue());
            System.out.println("-------------------------------------");

        }
    }

    // Count Students
    public void totalStudents() {
        System.out.println("Total Students : " + students.size());
    }

    // Check Student Exists
    public void checkStudent(int studentId) {

        if (students.containsKey(studentId)) {
            System.out.println("Student exists.");
        } else {
            System.out.println("Student does not exist.");
        }
    }
}
