package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProjectPage {
    private WebDriver driver;

    public CreateProjectPage(WebDriver driver){
        this.driver = driver;
    }

    private final By inputNameOfProject = By.id("name");
    private final By buttonAddProject = By.id("accept");
    private final By buttonCancelAddProject = By.id("admin-integration-form-cancel");

    public void nameOfProject(String projectName){
        driver.findElement(inputNameOfProject).sendKeys(projectName);
    }

    public void clickAddProject() {
        driver.findElement(buttonAddProject).click();
    }

    public void cancelAddProject() {
        driver.findElement(buttonCancelAddProject).click();
    }


}
