package Goresttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Config;

import static io.restassured.RestAssured.given;

public class Get_req {
    public int getall(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", Config.token)
                .when()
                .get("/users");
        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        return response.getStatusCode();

    }
    public int getId(String userId){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", Config.token)
                .when()
                .get("/users/"+userId);
        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        return response.getStatusCode();

    }
}
