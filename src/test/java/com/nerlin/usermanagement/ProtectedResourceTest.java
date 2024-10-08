package com.nerlin.usermanagement;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProtectedResourceTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testAccessProtectedResourceWithValidJwt() {
        String validToken = "eyJhbGci...";  // Inserisci qui un token JWT valido

        given()
            .header("Authorization", "Bearer " + validToken)
            .when()
            .get("/api/users/profile")
            .then()
            .statusCode(200)  // Verifica che l'accesso sia consentito
            .body("email", equalTo("newuser@example.com"));
    }

    @Test
    public void testAccessProtectedResourceWithoutJwt() {
        given()
            .when()
            .get("/api/users/profile")
            .then()
            .statusCode(401)  // Verifica che l'accesso senza token JWT sia negato
            .body("message", equalTo("Unauthorized"));
    }
}
