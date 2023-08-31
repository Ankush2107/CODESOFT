import java.util.*;

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void removeStudent(int rollNumber) {
        Student studentToRemove = null;

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed: " + studentToRemove.getName());
        } 
        else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } 
        else {
            System.out.println("List of students:");
            System.out.println();
            for (Student student : students) {
                System.out.println(student);
                System.out.println();
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}


