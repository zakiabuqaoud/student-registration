import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {

    public static void deleteItem(String fileName, String id){
        ArrayList<String> arrayList = storage(fileName);
        String[] subData;

        for (int i=0; i< arrayList.size();i++){
            subData = arrayList.get(i).split("#");
            if(subData[0].equals(id)){
                arrayList.remove(i);
                writeToFile(fileName, arrayList);
            }


        }


    }

    public static ArrayList<String> storage(String fileName) {
        ArrayList<String> allData = new ArrayList<>();
        String data;
        try {
            Scanner scanner = new Scanner(fileName);
            while (scanner.hasNext()){
                data = scanner.nextLine();
                allData.add(data);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return allData;
    }
    public static void writeToFile(String fileName, ArrayList<String> data){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String row : data){
                bufferedWriter.write(row + "\r\n");
            }
            bufferedWriter.close();
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
