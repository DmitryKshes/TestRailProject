package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    private WebDriver driver;

    public DashBoardPage(WebDriver driver){this.driver = driver;}

    private final By headerOfPage = By.xpath("//*[@id=\"content-header\"]/div/div[3]");
    private final By dropDownUserMenu = By.xpath("//a[@id='navigation-user']");
    private final By itemFromMenuMySettings = By.xpath("//a[@id='navigation-user-settings']");
    private final By itemFromMenuLogout = By.id("navigation-user-logout");
    private final By addProjectButton = By.xpath("//a[@id='sidebar-projects-add']");
    private final By getToProject = By.xpath("//a[text() = 'TMS_Project']");
    private final By buttonAdmin = By.id("navigation-admin");
    //*[@id="project-1"]/div[2]/div[1]/a

    public String dashboardPage() {
       return driver.findElement(headerOfPage).getText();
    }

    public void openDropDownMenu() {
        driver.findElement(dropDownUserMenu).click();
    }

    public MySettingsPage goToMySetting(){
        openDropDownMenu();
        driver.findElement(itemFromMenuMySettings).click();
        return new MySettingsPage(driver);
    }

    public LoginPage LogoutFromTestRail() {
         driver.findElement(itemFromMenuLogout).click();
         return new LoginPage(driver);
    }

    public void clickAddProjectButton(){
        driver.findElement(addProjectButton).click();
    }

    public AdministrationPage clickButtonAdmin(){
        driver.findElement(buttonAdmin).click();
        return new AdministrationPage(driver);
    }
}
