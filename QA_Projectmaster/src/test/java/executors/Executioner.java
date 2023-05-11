package executors;

import org.openqa.selenium.devtools.v109.page.model.GatedAPIFeatures;
import robot.GaiaRobot;

public class Executioner {
    public static void main(String[] args) {
        GaiaRobot aGaiaRobot = new GaiaRobot();

        aGaiaRobot.accessWebsiteCalled("https://google.com.br");

        GaiaRobot anotherGaiaRobot = new GaiaRobot();
        aGaiaRobot.accessWebsiteCalled("https://google.com.br");

        GaiaRobot otherGaiaRobot = new GaiaRobot();
        aGaiaRobot.accessWebsiteCalled("https://google.com.br");
    }
}
