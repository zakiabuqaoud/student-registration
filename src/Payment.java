import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Payment {
    String id;
    String amount;
    String paymentDate;
    String studentId;

    Payment(String id, String amount, String paymentDate, String  studentId){
        this.id=id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.studentId = studentId;
    };

    void addPaymentInFile(Payment payment){
        try {
            FileWriter fileWriter = new FileWriter(new File("files/payments.txt"), true);
            BufferedWriter write = new BufferedWriter(fileWriter);
            write.write("id:" + this.id + "#" + "amount:"+this.amount + "#" + "date:"+this.paymentDate + "#" + "studentId:"+this.studentId + "\r\n");
            write.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}