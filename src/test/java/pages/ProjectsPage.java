package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By successMessageCreateProject = By.cssSelector(".message.message-success");
    private final By buttonAddProject = By.cssSelector(".button.button-left.button-add");
    private final By buttonAddExampleProject = By.id("addExampleProject");
    private final By buttonDeleteProject = By.className("icon-small-delete");
    private final By buttonEditProject = By.className("icon-small-edit");

    public String successMessage(){
        return driver.findElement(successMessageCreateProject).getText();
    }

    public void clickAddProject(){
        driver.findElement(buttonAddProject).click();
    }

    public void clickAddExampleProject(){
        driver.findElement(buttonAddExampleProject).click();
    }

    public void clickDeleteProject(){
        driver.findElement(buttonDeleteProject).click();
    }

    public void clickEditProject(){
        driver.findElement(buttonEditProject).click();
    }
}
