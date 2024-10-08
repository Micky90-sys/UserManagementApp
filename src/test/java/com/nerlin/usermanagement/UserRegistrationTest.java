package com.nerlin.usermanagement;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserRegistrationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testUserRegistration() {
        String registrationPayload = "{ \"email\": \"newuser@example.com\", \"password\": \"password123\" }";

        given()
            .contentType("application/json")
            .body(registrationPayload)
            .when()
            .post("/api/auth/register")
            .then()
            .statusCode(201)  // Verifica che l'utente sia registrato con successo
            .body("message", equalTo("User registered successfully"));
    }
}
