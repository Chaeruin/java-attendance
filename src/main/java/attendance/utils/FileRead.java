package attendance.utils;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class FileRead {
    public static List<Crew> fileReadToAttendance() throws IOException {
        ClassLoader classLoader = FileRead.class.getClassLoader();
        File aText = new File(classLoader.getResource("attendances.csv").getFile());
        FileReader aReader = new FileReader(aText);
        BufferedReader br = new BufferedReader(aReader);

        List<Crew> crews = new LinkedList<>();

        String input = br.readLine();
        while ((input = br.readLine()) != null) {
            setAttendanceAboutNickName(input, crews);
        }
        br.close();
        return crews;
    }

    public static void setAttendanceAboutNickName(String input, List<Crew> crews) {
        String[] inputs = input.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(inputs[1], formatter);
        for (Crew crew : crews) {
            if (crew.getName().equals(inputs[0])) {
                crew.getAttendance().addToAttendBook(localDateTime);
            } else {
                Crew newCrew = new Crew(inputs[0], new Attendance(new LinkedHashMap<>()));
                newCrew.getAttendance().addToAttendBook(localDateTime);
                crews.add(newCrew);
            }
        }
    }
}
