package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashBoardPage;

import java.time.Duration;

public class DashboardSteps {
    private final DashBoardPage dashBoardPage;
    WebDriverWait wait;

    public DashboardSteps(WebDriver driver) {
        this.dashBoardPage = new DashBoardPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Step(value = "Выход из системы авторизованным пользователем: {email}")
    public void logout(){
        dashBoardPage.openDropDownMenu();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-user-logout")));
        dashBoardPage.LogoutFromTestRail();
    }
}
