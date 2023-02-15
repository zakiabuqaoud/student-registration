import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {

    public static void deleteItem(String fileName, String id) {
        ArrayList<String> arrayList = storage(fileName);
        String[] subData;

        for (int i = 0; i < arrayList.size(); i++) {
            subData = arrayList.get(i).split("#");
            if (subData[0].equals(id)) {
                arrayList.remove(i);
                writeToFile(fileName, arrayList);
            }


        }


    }

    public static ArrayList<String> storage(String fileName) {
        ArrayList<String> allData = new ArrayList<>();
        String data;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                allData.add(data);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return allData;
    }

    public static void writeToFile(String fileName, ArrayList<String> data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String row : data) {
                bufferedWriter.write(row + "\r\n");
            }
            bufferedWriter.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static String getID(int num) {
        String finalCount = "0";
        ArrayList<String> countArrayList = storage("count.txt");
        String countRow = countArrayList.get(0);
        String[] countsArray = countRow.split("#");
        //is student id
        if(num == 0){
            finalCount = countsArray[0];
            String paymentCount = countsArray[1];
            String levelAndStudentCount = countsArray[2];
            int finalIntCount = Integer.parseInt(finalCount);
            finalIntCount++;
            String s = finalIntCount + "#" + paymentCount + "#" + levelAndStudentCount;
            countArrayList.clear();
            countArrayList.add(s);
            writeToFile("count.txt", countArrayList);
        }
        //is payment id
        if(num == 1){
            finalCount = countsArray[1];
            String studentCount = countsArray[0];
            String levelAndStudentCount = countsArray[2];
            int finalIntCount = Integer.parseInt(finalCount);
            finalIntCount++;
            String s = studentCount + "#" + finalIntCount + "#" + levelAndStudentCount;
            countArrayList.clear();
            countArrayList.add(s);
            writeToFile("count.txt", countArrayList);
        }

        //level and student id
        if(num ==2){
            finalCount = countsArray[2];
            String studentCount = countsArray[0];
            String paymentCount = countsArray[1];
            int finalIntCount = Integer.parseInt(finalCount);
            finalIntCount++;
            String s = studentCount + "#" + paymentCount + "#" + finalIntCount;
            countArrayList.clear();
            countArrayList.add(s);
            writeToFile("count.txt", countArrayList);
        }
        return finalCount;
    }
}
