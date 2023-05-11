package executors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import robot.GaiaRobot;

import java.time.Duration;

@DisplayName("Tests class for initial page")
public class TestX {
    @Test
    @DisplayName("If the page title is correct, validate as correct on the Liferay website")
    public void validatePageTitle() {
        GaiaRobot auntGaiaJonas = new GaiaRobot();

        auntGaiaJonas.accessWebsiteCalled("https://www.liferay.com/pt/");

        String pageTitle = auntGaiaJonas.takePageTitle();

        Assertions.assertEquals("Plataforma de Experiência Digital para Soluções Customizadas | Liferay", pageTitle);

    }

    @Test
    @DisplayName("Validating data from a survey on the Liferay website")
    public void validateSurveyData() {
        WebDriverManager.chromedriver().setup();
        WebDriver navigator = new ChromeDriver();

        navigator.get("https://www.liferay.com/pt/");

        WebDriverWait wait = new WebDriverWait(navigator, Duration.ofSeconds(3));

        WebElement cookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler' and contains(.,'Accept All')]")));

        cookies.click();

        navigator.findElement(By.xpath("//a[@class='search-button w-inline-block']")).click();

        WebDriverWait wait2 = new WebDriverWait(navigator, Duration.ofSeconds(3));
        WebElement searchBar = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchInput']")));
        searchBar.click();

        navigator.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("YourUserName");

        WebDriverWait wait3 = new WebDriverWait(navigator, Duration.ofSeconds(3));
        WebElement assertText = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='st-no-results']")));
        assertText.getText();

        String resultObtained = navigator.findElement(By.xpath("//div[@id='st-no-results']")).getText();

        Assertions.assertEquals("Não há resultados.", resultObtained);

        navigator.quit();
        
    }
}

