package tests.api;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectTest extends ApiBaseTest {

    Integer projectCreateId;
    String projectName;

    @Epic("CRUD с проектом")
    @Test(description = "Создание сущности проект")
    public void createProjectTest(){
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .body("{\"name\": \"test project api\"}")
                .log().all()
                .when()
                .post("index.php?/api/v2/add_project");
        response.then()
                .statusCode(200)
                .log().all();
        projectCreateId = response.path("id");
        projectName = response.path("name");
    }

    @Test(description = "Просмотр сущности проект", dependsOnMethods = "createProjectTest")
    public void getProjectTest(){
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/index.php?/api/v2/get_project/" + projectCreateId);
        response.then()
                .statusCode(200)
                .body(
                        "id", equalTo(projectCreateId),
                        "name", equalTo(projectName))
                .log().all();
    }

    @Test(description = "Обновление теста", dependsOnMethods = "createProjectTest")
    public void updateProjectTest() {
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body("{\"announcement\": \"test update project\" }")
                .post("index.php?/api/v2/update_project/" + projectCreateId);
        response.then()
                .statusCode(200)
                .body(
                        "name", equalTo(projectName),
                        "announcement", equalTo("test update project")
                )
                .log().all();

    }

    @Test(description = "Удаление проекта", dependsOnMethods = "updateProjectTest")
    public void deleteProjectTest(){
        Response response = given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(login, password)
                .contentType(ContentType.JSON)
                .body("")
                .log().all()
                .when()
                .post("index.php?/api/v2/delete_project/" + projectCreateId);
        response.then()
                .statusCode(200)
                .log().all();
    }


}
