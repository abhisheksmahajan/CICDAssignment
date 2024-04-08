package Goresttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Config;

import static io.restassured.RestAssured.given;

public class Delete_req {
    public int DeleteUser(String userId) {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        Response response = given()
                .header("Authorization", Config.token)
                .when()
                .delete("/users/" + userId);

        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        return response.statusCode(); // Assuming 204 is the expected status code for successful deletion
    }
}
