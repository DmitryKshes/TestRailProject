package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    private WebDriver driver;

    public DashBoardPage(WebDriver driver){this.driver = driver;}

    private final By headerOfPage = By.xpath("//*[@id=\"content-header\"]/div/div[3]");

    public String dashboardPage() {
       return driver.findElement(headerOfPage).getText();
    }
}
