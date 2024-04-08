package Goresttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Config;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put_req {
    Get_req get= new Get_req();
    public int updateUser(String name,String email,String gender,String status ) {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        String requestBody = "{\"name\":\"" + name + "\",\"email\":\"" + email + "\",\"gender\":\""+gender+"\",\"status\":\""+status+"\"}";

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", Config.token)
                .body(requestBody)
                .when()
                .patch("/users/" + Config.userId);

        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        get.getId(Config.userId);
        return response.statusCode(); // Assuming 200 is the expected status code
    }
    public int invalidputrequest(String name, String email, String gender, String status) {
        RestAssured.baseURI = Config.url + "/public/v2";

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("name", name);
        requestBodyMap.put("email", email);
        requestBodyMap.put("gender", gender);
        requestBodyMap.put("status", status);

        StringBuilder requestBodyBuilder = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : requestBodyMap.entrySet()) {
            requestBodyBuilder.append("\"").append(entry.getKey()).append("\":\"");
            if (entry.getValue() != null) {
                requestBodyBuilder.append(entry.getValue());
            }
            requestBodyBuilder.append("\",");
        }

        requestBodyBuilder.deleteCharAt(requestBodyBuilder.length() - 1);
        requestBodyBuilder.append("}");

        String requestBody = requestBodyBuilder.toString();

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", Config.token)
                .body(requestBody)
                .put("/users");

        System.out.println("Status:" + response.getStatusCode());
        System.out.println("Body:" + response.getBody().asString());

//            Config.userId = response.jsonPath().getString("id");
//            System.out.println(Config.userId);

        return response.getStatusCode();
    }
}
