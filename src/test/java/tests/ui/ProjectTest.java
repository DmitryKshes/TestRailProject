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
public class ProjectTest extends BaseTest {

    @Test(priority = 1, description = "Проверка создания проекта со страницы Dashboard")
    public void createProjectFromDashboardPageTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickAddProjectButton();
        AddProjectSteps addProjectSteps = new AddProjectSteps(driver);
        addProjectSteps.addProject("Test project 1");
        ProjectsPage projectsPage = new ProjectsPage(driver);
        String checkMessage = projectsPage.successMessage();
        Assert.assertEquals(checkMessage, "Successfully added the new project.", "Project don't created.");
    }

    @Test(priority = 1, description = "Проверка создания проекта со страницы Projects")
    public void createProjectFromProjectsPageTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
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

    @Test(priority = 2, description = "Изменение проекта")
    public void editProjectTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        driver.get(baseUrl + "/index.php?/admin/projects/overview");
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.clickEditProject();
        String checkEdit = projectsPage.editProjectPage();
        Assert.assertEquals(checkEdit, "Edit Project", "not edit page");
    }

    @Test(priority = 3, description = "Создание пример проекта")
    public void addExampleProjectTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        driver.get(baseUrl + "/index.php?/admin/projects/overview");
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.clickAddExampleProject();
        projectsPage.enterNameExampleProject();
        projectsPage.clickExampleProjectSubmit();
        String checkAddExampleProject = projectsPage.checkAddExamplePage();
        Assert.assertEquals(checkAddExampleProject, "example test project", "not add example project");
    }

    @Test(priority = 3, description = "Удаление проекта")
    public void deleteProjectFromDashboardTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        driver.get(baseUrl + "/index.php?/admin/projects/overview");
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.clickDeleteProjectButton();
        projectsPage.activeDeleteProjectCheckbox();
        projectsPage.acceptDeleteProjectButton();
        String checkDeleteProjectMessage = projectsPage.successDeletedProjectMessage();
        Assert.assertEquals(checkDeleteProjectMessage, "Successfully deleted the project.", "Project don't deleted.");
    }
}
