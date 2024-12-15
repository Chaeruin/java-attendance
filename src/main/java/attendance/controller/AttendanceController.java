package attendance.controller;

import attendance.domain.Crew;
import attendance.enums.Attend;
import attendance.service.AttendanceService;
import attendance.service.CrewService;
import attendance.utils.InputParser;
import attendance.utils.InputValidator;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.util.List;

public class AttendanceController {
    final InputView inputView;
    final OutputView outputView;
    final AttendanceService attendanceService;
    final CrewService crewService;


    public AttendanceController(InputView inputView, OutputView outputView, AttendanceService attendanceService,
                                final CrewService crewService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.attendanceService = attendanceService;
        this.crewService = crewService;
    }

    static List<Crew> crews;


    public void run() {
        crews = crewService.settingCrewsAbsent();
        String mainMenuInput = inputView.getMenu();
        while (!mainMenuInput.equals("Q")) {
            if (mainMenuInput.equals("1")) {
                checkAttendance();
            } else if (mainMenuInput.equals("2")) {
                modifyAttendance();
            } else if (mainMenuInput.equals("3")) {
                crewsAttendCheck();
            } else if (mainMenuInput.equals("4")) {
                warningCrewCheck();
            }

            mainMenuInput = inputView.getMenu();
        }

    }

    public void checkAttendance() {
        InputValidator.isNowWeekEnd();
        Crew crew = InputParser.parseCrew(crews, inputView.getNickName());
        LocalDateTime goTime = InputParser.parseDateTime(DateTimes.now(), inputView.getTime());

        LocalDateTime key = attendanceService.checkingAttend(crew, goTime);
        outputView.printCheckingAttend(goTime, crew, key);
    }

    public void modifyAttendance() {
        Crew crew = InputParser.parseCrew(crews, inputView.getModifyNickName());
        int date = InputParser.parseDate(inputView.getModifyDate());

        LocalDateTime beforeTime = crew.getAttendance().findByKeyByDate(date);
        LocalDateTime whenTime = InputParser.parseDateTime(beforeTime, inputView.getModifyTime());
        Attend beforeAttend = crew.getAttendance().getAttendanceBook().get(beforeTime);
        LocalDateTime key = attendanceService.modifyingAttend(crew, date, whenTime);
        outputView.printModifyingAttend(whenTime, crew, key, beforeTime, beforeAttend);
    }

    public void crewsAttendCheck() {
        Crew crew = InputParser.parseCrew(crews, inputView.getNickName());
        outputView.printAttendCheck(crew);
    }

    public void warningCrewCheck() {
        outputView.printCheckAll(crews);
    }
}
