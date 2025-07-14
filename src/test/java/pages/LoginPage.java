package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailInput = By.id("name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("button_primary");
    private final By loginRequiredNotification = By.xpath("//form/div[text() = 'Email/Login is required.']");
    private final By passwordRequiredNotification = By.xpath("//form/div[text() = 'Password is required.']");
    private final By invalidDataNotification = By.xpath("//div/div[text() = 'Email/Login or Password is incorrect. Please try again.']");


}
