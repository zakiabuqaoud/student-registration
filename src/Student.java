import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String id;
    String name;
    String phoneNumber;
    String RegisterDate;

    Student() {

    }

    Student(String id, String name, String phoneNumber, String RegisterDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.RegisterDate = RegisterDate;
    }


    void addStudentInFile() {
        try {
            FileWriter fileWriter = new FileWriter(new File("students.txt"), true);
            BufferedWriter write = new BufferedWriter(fileWriter);
            write.write("id:" + this.id + "#" + "name:"+this.name + "#" + "phone:"+this.phoneNumber + "#" + "date:"+this.RegisterDate + "\r\n");
            write.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }




    public static void main(String[] argument) {

//        try {
//            Scanner scanner = new Scanner(file);
//            System.out.println(scanner.nextLine());
//            System.out.println(scanner.nextLine());
//            FileWriter fileWriter = new FileWriter(new File("students.txt"), true);
//            BufferedWriter write = new BufferedWriter(fileWriter);
//
//        } catch (Exception e) {
//            System.out.println("error zaki");
//
//        }
    }

}
