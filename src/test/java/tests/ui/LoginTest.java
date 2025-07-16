package tests.ui;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Проверка успешной авторизации")
    public void successLoginTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs("dmitriykshes@gmail.com", "dmitryKshesTMS_1");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String header = dashBoardPage.dashboardPage();
        Assert.assertEquals(header, "Dashboard", "not equal");
    }
}
