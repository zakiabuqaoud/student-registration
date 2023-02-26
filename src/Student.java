import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String id;
    String name;
    String phoneNumber;
    String RegisterDate;

    String fees;

    Student() {

    }

    Student(String id, String name, String phoneNumber, String RegisterDate, String fees) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.RegisterDate = RegisterDate;
        this.fees = fees;
    }


    void addStudentInFile() {
        try {
            FileWriter fileWriter = new FileWriter("files/students.txt", true);
            BufferedWriter write = new BufferedWriter(fileWriter);
            write.write("id:" + this.id + "#" + "name:"+this.name + "#" + "phone:"+this.phoneNumber + "#" + "date:"+this.RegisterDate+"#"+"fees:"+this.fees + "\r\n");
            write.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void main(String[] arg){

    }

}