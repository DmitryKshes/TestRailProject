package tests.ui;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import steps.LoginSteps;

@Epic("Авторизация пользователя")
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Проверка успешной авторизации")
    public void successLoginTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        DashBoardPage dashBoardPage = loginSteps.loginAs(login, password);
        String header = dashBoardPage.dashboardPage();
        Assert.assertEquals(header, "Dashboard", "not equal");
    }

    @Test(priority = 1, description = "Проверка авторизации без пароля")
    public void loginWithoutPasswordTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, "");
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationForPassword = loginPage.passwordNotification();
        Assert.assertEquals(checkNotificationForPassword, "Password is required.", "Invalid notification");
    }

    @Test(priority = 1, description = "Проверка авторизации без email")
    public void loginWithOutEmailTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("", password);
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationForEmail = loginPage.loginNotification();
        Assert.assertEquals(checkNotificationForEmail, "Email/Login is required.", "Invalid notification");
    }

    @Test(priority = 1, description = "Проверка авторизации с невалидным паролем")
    public void loginWithInvalidParametersTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, "1");
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationShortPassword = loginPage.invalidData();
        Assert.assertEquals(checkNotificationShortPassword, "Password is too short (5 characters required).", "Invalid notification");
    }
}
