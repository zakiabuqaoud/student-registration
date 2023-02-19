import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {

    public static void deleteItem(String fileName, String id) {
        ArrayList<String> arrayList = storage(fileName);
        String[] subData;
        String[] subSubIDData;
        int index = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            subData = arrayList.get(i).split("#");
            subSubIDData = subData[0].split(":");
            if (subSubIDData[1].equals(id)) {
                index = i;
            }
        }
        arrayList.remove(index);
        writeToFile(fileName, arrayList);
    }

    public static void updatePayment(String id, String payment, String paymentDate, String studentID) {
        ArrayList<String> arrayList = storage("payments.txt");
        String[] subData;
        String[] subSubIDData;
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            subData = arrayList.get(i).split("#");
            subSubIDData = subData[0].split(":");
            if (subSubIDData[1].equals(id)) {
                index = i;
            }
        }
        arrayList.set(index, "id:" + id + "#" + "payment:" + payment + "#" + "date:" + paymentDate + "#" + "studentId:" + studentID);
        writeToFile("payments.txt", arrayList);


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
        if (num == 0) {
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
        if (num == 1) {
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
        if (num == 2) {
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

    public static Boolean levelIsExist(String levelID, String studentID) {
        ArrayList<String> levelsAndStudentsIDs = storage("levelidWithstudentid.txt");
        for (String row : levelsAndStudentsIDs) {
            String[] subRow = row.split("#");
            String levelIDInFile = subRow[1];
            String studentIDInFile = subRow[2];
            String subSubRowLevelID[] = levelIDInFile.split(":");
            String subSubRowStudentID[] = studentIDInFile.split(":");
            if (levelID.equals(subSubRowLevelID[1]) && studentID.equals(subSubRowStudentID[1])) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> displayLevels(String studentID) {
        ArrayList<String> levels = new ArrayList<String>();
        ArrayList<String> levelsAndStudentsIDs = storage("levelidWithstudentid.txt");
        for (String row : levelsAndStudentsIDs) {
            String[] subRow = row.split("#");
            String levelIDInFile = subRow[1];
            String studentIDInFile = subRow[2];
            String subSubRowLevelID[] = levelIDInFile.split(":");
            String subSubRowStudentID[] = studentIDInFile.split(":");
            if (subSubRowStudentID[1].equals(studentID)) {
                if (subSubRowLevelID[1].equals("1")) {
                    levels.add("A1");
                } else if (subSubRowLevelID[1].equals("2")) {
                    levels.add("A2");
                } else if (subSubRowLevelID[1].equals("3")) {
                    levels.add("B1");
                } else if (subSubRowLevelID[1].equals("4")) {
                    levels.add("B2");

                } else if (subSubRowLevelID[1].equals("5")) {
                    levels.add("C1");

                } else if (subSubRowLevelID[1].equals("6")) {
                    levels.add("C2");
                }
            }
        }

        return levels;
    }

    public static void deleteLevel(String levelID, String studentID) {
        ArrayList<String> levelsAndStudentsIDs = storage("levelidWithstudentid.txt");
        int index = 0;
        for (String row : levelsAndStudentsIDs) {
            String[] subRow = row.split("#");
            String levelIDInFile = subRow[1];
            String studentIDInFile = subRow[2];
            String subSubRowLevelID[] = levelIDInFile.split(":");
            String subSubRowStudentID[] = studentIDInFile.split(":");
            if (levelID.equals(subSubRowLevelID[1]) && studentID.equals(subSubRowStudentID[1])) {
                index = levelsAndStudentsIDs.indexOf(row);
                break;
            }
        }
        levelsAndStudentsIDs.remove(index);
        writeToFile("levelidWithstudentid.txt", levelsAndStudentsIDs);

    }

    public static ArrayList<String> displayPayments(String studentID) {
        ArrayList<String> paymentsArrayList = new ArrayList<String>();
        ArrayList<String> payments = storage("payments.txt");
        for (String row : payments) {
            String[] subRow = row.split("#");
            String studentIDInFile = subRow[3];
            String[] subStudentIDInFile = studentIDInFile.split(":");
            if (subStudentIDInFile[1].equals(studentID)) {
                paymentsArrayList.add(row);
            }
        }
        return paymentsArrayList;
    }

    public static Boolean checkNameNotExist(String name) {
        ArrayList<String> studentData = storage("students.txt");
        for (String row : studentData) {
            if (row.contains(name)) {
                return false;
            }
        }
        return true;
    }

    public static void deletePaymentAndLevelForStudent(String name) {
        String id = "";
        ArrayList<String> rows = storage("students.txt");
        for (String row : rows) {
            if (row.contains(name)) {
                String[] subRow = row.split("#");
                String[] subSubRow = subRow[0].split(":");
                id = subSubRow[1];
            }
        }
        deletePaymentsForStudent(id);
        deleteLevelsForStudent(id);
    }

    public static void deletePaymentsForStudent(String studentId) {
        ArrayList<String> indexGrupe = new ArrayList<String>();
        ArrayList<String> paymentsFromFile = storage("payments.txt");
        for (String row : paymentsFromFile) {
            String[] subRow = row.split("#");

            String[] subSubRow = subRow[3].split(":");
            if (subSubRow[1].equals(studentId)) {
                indexGrupe.add(row);
            }
        }
        int size = indexGrupe.size();
        for (int i = 0; i < size; i++) {
            paymentsFromFile.remove(indexGrupe.get(i));
        }
        writeToFile("payments.txt", paymentsFromFile);
    }

    public static void deleteLevelsForStudent(String studentId) {
        ArrayList<String> indexGrupe = new ArrayList<String>();
        ArrayList<String> levelsFromFile = storage("levelidWithstudentid.txt");
        for (String row : levelsFromFile) {
            String[] subRow = row.split("#");
            String[] subSubRow = subRow[2].split(":");
            if (subSubRow[1].equals(studentId)) {
                indexGrupe.add(row);
            }
        }
        int size = indexGrupe.size();
        for (int i = 0; i < size; i++) {
            levelsFromFile.remove(indexGrupe.get(i));
        }
        writeToFile("levelidWithstudentid.txt", levelsFromFile);
    }
}
