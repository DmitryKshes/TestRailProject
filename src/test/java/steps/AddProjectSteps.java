package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;

public class AddProjectSteps {
    private final CreateProjectPage createProjectPage;

    public AddProjectSteps(WebDriver driver){
        this.createProjectPage = new CreateProjectPage(driver);
    }

    @Step("Создание проекта на Dashboard: {projectName}")
    public void addProject(String projectName){
        createProjectPage.nameOfProject(projectName);
        createProjectPage.clickAddProject();
    }
}
