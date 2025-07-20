package tests.ui;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.DashboardSteps;
import steps.LoginSteps;

@Epic("Разлогирование пользователя")
public class LogoutTest extends BaseTest {

    @Test(priority = 2, description = "Проверка успешного выхода по кнопке Log Out")
    public void successLogOutFromApplication() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("dmitriykshes@gmail.com", "dmitryKshesTMS_1");
        DashboardSteps dashboardSteps = new DashboardSteps(driver);
        dashboardSteps.logout();
        LoginPage loginPage = new LoginPage(driver);
        String checkHeadingLoginPage = loginPage.headingLoginPage();
        Assert.assertEquals(checkHeadingLoginPage, "TestRail Q", "Not Log Out");
    }
}
