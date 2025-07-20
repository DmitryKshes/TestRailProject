package tests.ui;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        loginSteps.loginAs("dmitriykshes@gmail.com", "dmitryKshesTMS_1");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String header = dashBoardPage.dashboardPage();
        Assert.assertEquals(header, "Dashboard", "not equal");
    }

    @Test(priority = 1, description = "Проверка авторизации без пароля")
    public void loginWithoutPasswordTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("dmitriykshes@gmail.com", "");
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationForPassword = loginPage.passwordNotification();
        Assert.assertEquals(checkNotificationForPassword, "Password is required.", "Invalid notification");
    }

    @Test(priority = 1, description = "Проверка авторизации без email")
    public void loginWithOutEmailTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("", "qwerty5432_1");
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationForEmail = loginPage.loginNotification();
        Assert.assertEquals(checkNotificationForEmail, "Email/Login is required.", "Invalid notification");
    }

    @Test(priority = 1, description = "Проверка авторизации без ввода email и пароля")
    public void loginWithInvalidParameters() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("test@gmail.com", "qwerty5432_1");
        LoginPage loginPage = new LoginPage(driver);
        String checkNotificationInvalidParameters = loginPage.invalidData();
        Assert.assertEquals(checkNotificationInvalidParameters, "Email/Login or Password is incorrect. Please try again.", "Invalid notification");
    }
}
