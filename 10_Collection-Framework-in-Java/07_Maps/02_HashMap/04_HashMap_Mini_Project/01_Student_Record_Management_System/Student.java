package Collections.Maps.HashMap.StudentRecordManagementSystem;

public class Student {

    private int studentId;
    private String name;
    private int age;
    private String department;
    private double marks;

    // Constructor
    public Student(int studentId, String name, int age, String department, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.marks = marks;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID : " + studentId +
               "\nName       : " + name +
               "\nAge        : " + age +
               "\nDepartment : " + department +
               "\nMarks      : " + marks;
    }
}
