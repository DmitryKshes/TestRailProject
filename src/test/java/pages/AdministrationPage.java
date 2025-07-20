package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage {
    private WebDriver driver;

    public AdministrationPage(WebDriver driver){this.driver = driver;}

    private final By projectsTab = By.id("navigation-sub-projects");


    public void clickProjectsTab(){
        driver.findElement(projectsTab).click();
    }

}
