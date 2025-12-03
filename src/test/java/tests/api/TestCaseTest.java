package tests.api;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCaseTest extends ApiBaseTest {

    Integer section_id = 10;
    Integer test_case_id;

    @Epic("CRUD с тест-кейсами")
    @Test(description = "Создание тест-кейса")
    public void createTestCase() {
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .body("{\"title\": \"test case api\"}")
                .log().all()
                .when()
                .post("index.php?/api/v2/add_case/" + section_id);
        response.then()
                .statusCode(200)
                .log().all();
        test_case_id = response.path("id");
        System.out.println(test_case_id);
    }

    @Test(description = "Просмотр тест-кейса", dependsOnMethods = "createTestCase")
    public void getTestCase(){
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("index.php?/api/v2/get_case/" + test_case_id);
        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test(description = "Обновление тест-кейса", dependsOnMethods = "createTestCase")
    public void updateTestCase(){
        Response response = given()
            .baseUri(baseUrl)
            .auth().preemptive().basic(login, password)
            .contentType(ContentType.JSON)
            .log().all()
            .when()
            .body("{\"estimate\": \"5m\"}")
            .post("index.php?/api/v2/update_case/" + test_case_id);
        response.then()
            .statusCode(200)
            .log().all();
    }

    @Test(description = "Удаление тест-кейса", dependsOnMethods = "updateTestCase")
    public void deleteTestCase(){
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("index.php?/api/v2/delete_case/" + test_case_id);
        response.then()
                .statusCode(200)
                .log().all();
    }
}
