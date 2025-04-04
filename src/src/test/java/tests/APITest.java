package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class APITest {


    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    @Test
    public void test_shouldBeAbleToFetchAllCharacters() {
        Response response = given()
                .when()
                .get("/character")
                .then()
                .statusCode(200)
                .body("results[0].id", equalTo(1))
                .extract().response();

        System.out.println("Response Body" + response.asString());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_shouldBeAbleToFetchDetailsOfAnExistingCharacter() {
        Response response = given()
                .when()
                .get("/character/6")
                .then()
                .statusCode(200)
                .body("id", equalTo(6))
                .extract().response();

        System.out.println("Response Body:" + response.asString());
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_shouldBeAbleToFetchDetailsOfMultipleCharacters() {
        Response response = given()
                .when()
                .get("/character/3,7,15")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Object> characters = response.jsonPath().getList("$");

        System.out.println("Characters: " + characters);
        System.out.println("Number of characters: " + characters.size());
        assertFalse("Character list should not be empty", characters.isEmpty());
    }

    @Test
    public void test_shouldBeAbleToFetchDetailsUnder5000ms() {
        Response response = given()
                .when()
                .get("/character")
                .then()
                .statusCode(200)
                .extract()
                .response();

        long responseTime = response.getTime();
        System.out.println("Response Time: " + responseTime + "ms");
        assertTrue("Response time exceeds maximum allowed latency", responseTime < 5000);
    }

    @Test
    public void test_shouldGive404OnInvalidRequest() {
        Response response = given()
                .when()
                .get("/character/99999")
                .then()
                .statusCode(404)
                .body("error", equalTo("Character not found"))
                .extract().response();

        System.out.println("Response Body:" + response.asString());
        assertEquals(404, response.getStatusCode());
    }
}