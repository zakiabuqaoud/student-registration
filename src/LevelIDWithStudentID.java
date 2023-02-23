import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LevelIDWithStudentID {
    String id;
    String  levelID;
    String studentId;

    LevelIDWithStudentID(String id, String levelID, String studentId) {
        this.id = id;
        this.levelID = levelID;
        this.studentId = studentId;
    }

    void addLevelInFile(LevelIDWithStudentID level) {
        try {
            FileWriter fileWriter = new FileWriter(new File("files/levelidWithstudentid.txt"), true);
            BufferedWriter write = new BufferedWriter(fileWriter);
            write.write("id:" + this.id + "#" + "levelID:" + this.levelID + "#" + "studentId:" + this.studentId + "\r\n");
            write.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        }
    }
}