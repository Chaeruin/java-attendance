package attendance.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void fileReadToAttendance() throws IOException {
        ClassLoader classLoader = FileRead.class.getClassLoader();
        File aText = new File(classLoader.getResource("attendances.csv").getFile());
        FileReader aReader = new FileReader(aText);
        BufferedReader br = new BufferedReader(aReader);
        String input = br.readLine();
        while ((input = br.readLine()) != null) {

        }
        br.close();
    }

    public static void setAttendanceAboutNickName(String input) {
        
    }
}
