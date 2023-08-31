import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class DataStorage {

        public static void writeStudentsToFile(ArrayList<Student> students, String fileName) {

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (Student student : students) {
                    writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade() + "," + student.getAge());
                }

            } 
            catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void readStudentsFromFile(List<Student> list, String fileName) {

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0];
                        int rollNumber = Integer.parseInt(parts[1]);
                        String grade = parts[2];
                        int age = Integer.parseInt(parts[3]);
                        Student student = new Student(name, rollNumber, grade, age);
                        list.add(student);
                    }
                }

            }
            catch (FileNotFoundException e) {

                // File doesn't exist yet, it will be created when writing
                System.out.println("No data file found. Creating a new one...");

            }
            catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
