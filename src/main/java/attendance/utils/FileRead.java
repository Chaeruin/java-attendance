package attendance.utils;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class FileRead {
    public static List<Crew> fileReadToAttendance() {
//        ClassLoader classLoader = FileRead.class.getClassLoader();
//        File aText = new File(classLoader.getResource("attendances.csv").getFile());
//        FileReader aReader = new FileReader(aText);
//        BufferedReader br = new BufferedReader(aReader);

        BufferedReader br = null;
        List<Crew> crews = new LinkedList<>();
        try {
            br = Files.newBufferedReader(Paths.get("./src/main/resources/attendances.csv"));
            String input = br.readLine();
            while ((input = br.readLine()) != null) {
                setAttendanceAboutNickName(input, crews);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return crews;
    }

    public static void setAttendanceAboutNickName(String input, List<Crew> crews) {
        String[] inputs = input.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(inputs[1], formatter);
        Crew newCrew = null;
        for (Crew crew : crews) {
            if (crew.getName().equals(inputs[0])) {
                newCrew = crew;
            }
        }
        if (newCrew == null) {
            newCrew = new Crew(inputs[0], new Attendance(new LinkedHashMap<>()));
            crews.add(newCrew);
        }
        newCrew.getAttendance().addToAttendBook(localDateTime);
    }
}
