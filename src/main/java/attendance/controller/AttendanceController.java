package attendance.controller;

import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceController {
    final InputView inputView;
    final OutputView outputView;


    public AttendanceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        String mainMenuInput = inputView.getMenu();
        while (!mainMenuInput.equals("Q")) {
            if (mainMenuInput.equals("1")) {

            } else if (mainMenuInput.equals("2")) {

            } else if (mainMenuInput.equals("3")) {

            } else if (mainMenuInput.equals("4")) {

            }

            mainMenuInput = inputView.getMenu();
        }

    }


}
