package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectsPage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver){
        this.driver = driver;
    }

    private final By successMessageCreateProject = By.cssSelector(".message.message-success");
    private final By addProjectButton = By.cssSelector(".button.button-left.button-add");
    private final By addExampleProjectButton = By.id("addExampleProject");
    private final By deleteProjectButton = By.xpath("//tr[td/a[text()='Test 2']]//div[@data-testid='projectDeleteButton']");
    private final By editProjectButton = By.xpath("//tr[td/a[text()='Test 2']]//div[@data-testid='projectEditButton']");
    private final By acceptDeleteProjectCheckBox = By.xpath("//div/label/span/strong[text()='Yes, delete this project (cannot be undone)']");
    private final By acceptDeleteProjectButton = By.xpath("//a[@data-testid = 'caseFieldsTabDeleteDialogButtonOk']");
    private final By successDeleteMessage = By.cssSelector(".message.message-success");
    private final By checkEditPageProject = By.cssSelector(".content-header-title.page_title");
    private final By nameExampleProject = By.id("addProjectName");
    private final By exampleProjectSubmit = By.id("addProjectSubmit");
    private final String nameOfExampleProject = "example test project";
    private final By checkExampleProjectPage = By.cssSelector(".content-header-title.page_title");

    public String successMessage(){
        return driver.findElement(successMessageCreateProject).getText();
    }

    public void clickAddProject(){
        driver.findElement(addProjectButton).click();
    }

    public void clickAddExampleProject(){
        driver.findElement(addExampleProjectButton).click();
    }

    public void clickEditProject(){
        driver.findElement(editProjectButton).click();
    }

    public void clickDeleteProjectButton() {
        driver.findElement(deleteProjectButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-ident-deleteDialog")));
    }

    public void clickExampleProjectSubmit() {
        driver.findElement(exampleProjectSubmit).click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void activeDeleteProjectCheckbox() {
        WebElement div = driver.findElement(acceptDeleteProjectCheckBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", div);
    }

    public void acceptDeleteProjectButton(){
        driver.findElement(acceptDeleteProjectButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String successDeletedProjectMessage(){
       return driver.findElement(successDeleteMessage).getText();
    }

    public String editProjectPage() {
        return driver.findElement(checkEditPageProject).getText();
    }

    public void enterNameExampleProject() {
        driver.findElement(nameExampleProject).sendKeys(nameOfExampleProject);
    }

    public String checkAddExamplePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
       return driver.findElement(checkExampleProjectPage).getText();
    }
}
