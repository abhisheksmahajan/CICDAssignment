package Goresttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.Config;


import java.util.HashMap;
import java.util.Map;

public class Post_req {

    public int postrequest(String name,String email,String gender,String status) {
        RestAssured.baseURI = Config.url+"/public/v2";


        String requestBody = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", " +
                "\"email\":\""+email+"\", \"status\":\""+status+"\"}";

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", Config.token)
                .body(requestBody)
                .post("/users");

        // Print the response body
        System.out.println("Status:"+response.getStatusCode());
        //for (String S1:)
        System.out.println("Body:"+response.getBody().asString());
        //response.prettyPrint();

        Config.userId = response.jsonPath().getString("id");
        System.out.println(Config.userId);

        return response.getStatusCode();
    }
    public int invalidpostrequest(String name, String email, String gender, String status) {
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
                    .post("/users");

            System.out.println("Status:" + response.getStatusCode());
            System.out.println("Body:" + response.getBody().asString());

//            Config.userId = response.jsonPath().getString("id");
//            System.out.println(Config.userId);

            return response.getStatusCode();
        }
}
