package tests.ui;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdministrationPage;
import pages.DashBoardPage;
import pages.ProjectsPage;
import steps.AddProjectSteps;
import steps.LoginSteps;

@Epic("Создание проекта")
public class CreateProjectTest extends BaseTest {

    @Test(priority = 3, description = "Проверка создания проекта со страницы Dashboard")
    public void createProjectFromDashboardPage() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("dmitriykshes@gmail.com", "dmitryKshesTMS_1");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickAddProjectButton();
        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("Test project 1");
        ProjectsPage projectsPage = new ProjectsPage(driver);
        String checkMessage = projectsPage.successMessage();
        Assert.assertEquals(checkMessage, "Successfully added the new project.", "Project don't created.");
    }

    @Test(priority = 3, description = "Проверка создания проекта со страницы Projects")
    public void createProjectFromProjectsPage(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("dmitriykshes@gmail.com", "dmitryKshesTMS_1");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickButtonAdmin();
        AdministrationPage administrationPage = new AdministrationPage(driver);
        administrationPage.clickProjectsTab();
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.clickAddProject();
        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("Test 2");
        String checkMessage = projectsPage.successMessage();
        Assert.assertEquals(checkMessage, "Successfully added the new project.", "Project don't created.");
    }
}
