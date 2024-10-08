package com.nerlin.usermanagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class UserLoginTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testUserLogin() {
        String loginPayload = "{ \"email\": \"newuser@example.com\", \"password\": \"password123\" }";
        
        Response response = given()
                .contentType("application/json")
                .body(loginPayload)
                .post("/api/auth/login")
                .then()
                .statusCode(200)  // Verifica che il login sia avvenuto con successo
                .extract().response();

        String token = response.path("token");
        assertNotNull(token, "Il token JWT non dovrebbe essere nullo");
    }
}
