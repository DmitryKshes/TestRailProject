package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CreateTestCasePage extends BaseTest {
    private WebDriver driver;

    public CreateTestCasePage(WebDriver driver){this.driver = driver;}
    private static final Logger log = LoggerFactory.getLogger(CreateTestCasePage.class);

    private final By testCaseInProjectPage = By.id("navigation-suites-dropdown");
    private final By addTestCaseButton = By.xpath("//a[text() = '\n" +
            "\t\t\t\t\t\tAdd Test Case\t\t\t\t\t']");
    private final By addTestCaseLink = By.xpath("//div/a[@data-testid = 'suiteAddCaseLink']");
    private final By addTestCaseFromHeader = By.xpath("//div/a[@data-testid = 'dynamicAddButton']");
    private final By addTestCaseButtonFromDropdown = By.xpath("//div/ul/li/a[@id = 'navigation-test-case']");
    private final By caseTitleInput = By.xpath("//form/input[@name = 'title']");
    private final String caseTitleName = "name for test case";
    private final By caseTitleButtonSubmit = By.className("icon-button-accept");
    private final By addTestCaseTitle = By.id("title");
    private final By addTestCaseTemplateField = By.id("template_id_chosen");
    private final By templateTestCase = By.xpath("//div[@id = 'template_id_chosen']//ul[contains(@data-testid,'compareVersionOption')]//li[text()='Test Case (Text)']");
    private final By addTestCaseTypeField = By.id("type_id_chosen");
    private final By typeTestCase = By.xpath("//div[@id = 'type_id_chosen']//ul[contains(@data-testid,'compareVersionOption')]//li[text()='Functional']");
    private final By addTestCasePriorityField = By.id("priority_id_chosen");
    private final By priorityTestCase = By.xpath("//div[@id = 'priority_id_chosen']//ul[contains(@data-testid,'compareVersionOption')]//li[text()='Medium']");
    private final By addTestCaseEstimateInput = By.id("estimate");
    private final By addTestCaseAddStep = By.className("addStep");
    private final String nameOfTestCase = "authorization on email and password";
    private final String estimationForTestCase = "60m";
    private final By firstStepDescription = By.xpath("//div[@id = 'custom_steps_display']//div[contains(@class,'fr-element') and @contenteditable='true']");
    private final By firstStepResult = By.xpath("//div[@id = 'custom_expected_display']//div[contains(@class,'fr-element') and @contenteditable='true']");
    private final By btnAddTestCase = By.id("accept");
    private final String secondTestStepText = "Enter password";
    private final String thirdTestStepText = "Click login button";
    private final By getToTestCases = By.id("navigation-suites-dropdown");

    public void waitFor(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public CreateTestCasePage addTestCaseByLink() {
        log.info("Создание тест-кейса в список по линке");
        driver.findElement(addTestCaseLink).click();
        driver.findElement(caseTitleInput).sendKeys(caseTitleName);
        driver.findElement(caseTitleButtonSubmit).click();
        return this;
    }

    public CreateTestCasePage addTestCaseByHeaderDynamicButton() {
        log.info("Добавление тест-кейса по кнопке из выпадающего списка в хэдере");
        driver.findElement(addTestCaseFromHeader).click();
        waitFor(addTestCaseButtonFromDropdown);
        driver.findElement(addTestCaseButtonFromDropdown).click();
        return this;
    }

    public CreateTestCasePage testCaseTitle() {
        log.info("Вводим название тест-кейса: {}", nameOfTestCase);
        driver.findElement(addTestCaseTitle).sendKeys(nameOfTestCase);
        return this;
    }

    public CreateTestCasePage testCaseTemplate() {
        log.info("Выбираем значение поля Template: {}", templateTestCase);
        driver.findElement(addTestCaseTemplateField).click();
        driver.findElement(templateTestCase).click();
        return this;
    }

    public CreateTestCasePage testCaseType() {
        log.info("Выбираем значение поля Type: {}", typeTestCase);
        waitFor(addTestCaseTypeField);
        driver.findElement(addTestCaseTypeField).click();
        driver.findElement(typeTestCase).click();
        return this;
    }

    public CreateTestCasePage testCasePriority() {
        log.info("Выбираем значение поля Priority: {}", priorityTestCase);
        driver.findElement(addTestCasePriorityField).click();
        driver.findElement(priorityTestCase).click();
        return this;
    }

    public CreateTestCasePage testCaseEstimate() {
        log.info("Ввод значения в поле Estimate: {}", estimationForTestCase);
        driver.findElement(addTestCaseEstimateInput).sendKeys(estimationForTestCase);
        return this;
    }

    public CreateTestCasePage addTestStep() {
        driver.findElement(addTestCaseAddStep).click();
        return this;
    }

    public CreateTestCasePage firstStep() {
        String firstTestStepText = "Enter login";
        log.info("Ввод значения в поле Steps: {}", firstTestStepText);
        driver.findElement(firstStepDescription).sendKeys(firstTestStepText);
        return this;
    }

    public CreateTestCasePage firstStepResult() {
        String firstExpectedResult = "Success";
        log.info("Ввод значения в поле Step Result: {}", firstExpectedResult);
        driver.findElement(firstStepResult).sendKeys(firstExpectedResult);
        return this;
    }

    public CreateTestCasePage clickAddCaseButton() {
        log.info("Сохранение тест-кейса");
        driver.findElement(btnAddTestCase).click();
        return this;
    }

    public CreateTestCasePage goToTestCase() {
        driver.get(baseUrl + "/index.php?/projects/overview/2");
        return this;
    }

    public CreateTestCasePage clickAddTestCases() {
        driver.findElement(getToTestCases).click();
        return this;
    }

    public CreateTestCasePage clickAddCase() {
        driver.findElement(addTestCaseButton).click();
        return this;
    }


}
