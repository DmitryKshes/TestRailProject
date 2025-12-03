package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step(value = "Логин под пользователем: {email}")
    public DashBoardPage loginAs(String email, String password){
        loginPage.enterEmailValue(email)
                 .enterPasswordValue(password)
                 .clickLoginButton();
        return new DashBoardPage(loginPage.getDriver());
    }
}
