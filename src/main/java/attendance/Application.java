package attendance;

import attendance.controller.AttendanceController;
import attendance.service.AttendanceService;
import attendance.service.CrewService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        AttendanceService attendanceService = new AttendanceService();
        CrewService crewService = new CrewService();

        AttendanceController attendanceController = new AttendanceController(inputView, outputView, attendanceService,
                crewService);

        attendanceController.run();
    }
}
