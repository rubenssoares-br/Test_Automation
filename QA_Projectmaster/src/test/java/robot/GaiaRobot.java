package robot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class GaiaRobot {
    public ChromeDriver julioDriver;
    public GaiaRobot() {
        WebDriverManager.chromedriver().setup();
        julioDriver = new ChromeDriver();

    }
    public void navigateLiferay() {
        julioDriver.get("https://www.liferay.com/pt/");
    }

    public void accessWebsiteCalled(String site) {
        julioDriver.get(site);
    }

    public String takePageTitle() {
        return julioDriver.getTitle();
    }

    public void login() {
        System.out.println("I will make login");
    }

    public void launchNote() {
        System.out.println("I will launch note");
    }
}
