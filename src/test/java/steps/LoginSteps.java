package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("Логин под пользователем: {email}")
    public void loginAs(String email, String password){
        loginPage.enterEmailValue(email);
        loginPage.enterPasswordValue(password);
        loginPage.clickLoginButton();
    }
}
