public class Student {

    private String name;
    private int rollNumber;
    private String grade;
    private int age;


    public Student(String name, int rollNumber, String grade, int age) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getAge() {
        return grade;
    }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setRollNumber(int rollNumber) {
    //     this.rollNumber = rollNumber;
    // }

    // public void setGrade(String Grade) {
    //     this.grade = grade;
    // }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\nAge: " + age;
    }
}