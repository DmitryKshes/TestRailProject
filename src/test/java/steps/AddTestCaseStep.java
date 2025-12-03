package steps;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CreateTestCasePage;
import pages.DashBoardPage;


public class AddTestCaseStep extends BaseTest {

    private final CreateTestCasePage createTestCasePage;
    private final DashBoardPage dashBoardPage;

    public AddTestCaseStep(WebDriver driver){
        this.createTestCasePage = new CreateTestCasePage(driver);
        this.dashBoardPage = new DashBoardPage(driver);
    }

    @Step(value = "Создание тест-кейса по кнопке из дропдауна")
    public void addTestCase(){
        createTestCasePage.goToTestCase()
                .clickAddTestCases()
                .addTestCaseByHeaderDynamicButton()
                .testCaseTitle()
                .testCaseTemplate()
                .testCaseType()
                .testCasePriority()
                .testCaseEstimate()
        //createTestCasePage.addTestStep();
                .firstStep()
                .firstStepResult()
                .clickAddCaseButton();
    }

    @Step("Создание тест-кейса и наполнение через линк на странице тест-кейсов проекта")
    public void addTestCaseFromDropDown(){
        createTestCasePage.goToTestCase()
                .clickAddTestCases()
                .addTestCaseByLink();
    }

}
