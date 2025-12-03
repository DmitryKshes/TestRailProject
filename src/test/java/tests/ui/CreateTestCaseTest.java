package tests.ui;

import base.BaseTest;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.AddTestCaseStep;
import steps.LoginSteps;

import static org.testng.Assert.assertTrue;

@Epic("Создание тест-кейсов")
public class CreateTestCaseTest extends BaseTest {
    @Test(description = "add tk")
    public void successAddTestCase() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        AddTestCaseStep addTestCaseStep = new AddTestCaseStep(driver);
        addTestCaseStep.addTestCase();
        assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Successfully added the new test case. ')]")).isDisplayed());
    }

    @Test(description = "add test case by link")
    public void successAddTestCaseByLink(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginAs(login, password);
        AddTestCaseStep addTestCaseStep = new AddTestCaseStep(driver);
        addTestCaseStep.addTestCaseFromDropDown();
        assertTrue(driver.findElement(By.xpath("//tr/td[contains(a, 'name for test case')]")).isDisplayed());
    }

}
