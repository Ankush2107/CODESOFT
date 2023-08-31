import java.util.Scanner;

class ConsoleStudentManagementApp {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManagementSystem managementSystem = new StudentManagementSystem();

        // Read student data from file
        DataStorage.readStudentsFromFile(managementSystem.getStudents(), "students.txt");

        while (true) {

            System.out.println("Student Management System \n");
            System.out.println("1. Add Student \n");
            System.out.println("2. Remove Student \n");
            System.out.println("3. Search Student \n");
            System.out.println("4. Display All Students \n");
            System.out.println("5. Exit \n");
            System.out.print("Enter your choice: ");
    

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:

                    System.out.print("Enter Student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade, age);
                    managementSystem.addStudent(newStudent);

                    DataStorage.writeStudentsToFile(managementSystem.getStudents(), "students.txt");
                break;

                case 2:

                    System.out.print("Enter roll number of student to remove: \n");
                    int rollToRemove = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    managementSystem.removeStudent(rollToRemove);

                    DataStorage.writeStudentsToFile(managementSystem.getStudents(), "students.txt");

                break;

                case 3:

                    System.out.print("Enter roll number of student to search: \n");
                    int rollToSearch = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    Student foundStudent = managementSystem.searchStudent(rollToSearch);

                    if (foundStudent != null) {
                        System.out.println("Student found:\n" + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }

                break;

                case 4:

                    managementSystem.displayAllStudents();

                break;

                case 5:

                    System.out.println("Exiting the program.");
                    System.exit(0);
                    
                default:

                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            System.out.println();
        }
    }
}