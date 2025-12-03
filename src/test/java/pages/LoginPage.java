package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailInput = By.id("name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("button_primary");
    private final By loginRequiredNotification = By.xpath("//div[text() = 'Email/Login is required.']");
    private final By passwordRequiredNotification = By.xpath("//div[text() = 'Password is required.']");
    private final By shortPasswordNotification = By.xpath("//div[text() = 'Password is too short (5 characters required).']");
    private final By headingOnLoginPage = By.xpath("//h1[text() = 'TestRail QA']");

    public LoginPage enterEmailValue(String email){
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterPasswordValue(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public String loginNotification(){
        return driver.findElement(loginRequiredNotification).getText();
    }

    public String passwordNotification() {
        return driver.findElement(passwordRequiredNotification).getText();
    }

    public String invalidData(){
        return driver.findElement(shortPasswordNotification).getText();
    }

    public DashBoardPage login(String email, String password){
        enterEmailValue(email);
        enterPasswordValue(password);
        clickLoginButton();

        return new DashBoardPage(driver);
    }

    public String headingLoginPage() {
        return driver.findElement(headingOnLoginPage).getText();
    }

}
