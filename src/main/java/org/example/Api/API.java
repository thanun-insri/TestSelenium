package org.example.Api;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;

public class API {
    String endpoint = "https://api.restful-api.dev";
    public void testMyApi() {

        Response response = given().baseUri(endpoint)
                .when().get("/objects")
                .then().assertThat().statusCode(200)
                .extract().response();

        JsonPath responseBody = response.jsonPath();
        String id = responseBody.getString("id[0]");
        String name = responseBody.getString("name[0]");
        String data = responseBody.getString("data[0]");
        System.out.println(id);
        System.out.println(name);
        System.out.println(data);
    }

    public void testMyApi2() {
        String requestBody = "{\"name\": \"Apple MacBook Pro 16\",\"data\": {\"year\": 2019,\"price\": 1849.99,\"CPU model\": \"Intel Core i9\",\"Hard disk size\": \"1 TB\"}}";

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(requestBody);
        }catch (JSONException err){
        }
        System.out.println(jsonObject.toString());
        Response response = given().baseUri(endpoint)
//                .queryParam("version", "1.0")
                .header("Content-Type", "application/json")
//                .header("Signature", "yoursignaturehere")
                .body(jsonObject.toString())
                .when().post("/objects")
                .then().assertThat().statusCode(200)
//                    .header("Content-Type", "application/json")
//                    .header("Cache-Control", "max-age=3600")
//                    .body("name", equalTo("Darmawan Hadiprasetyo"))
                    .extract().response();

        JsonPath responseBody = response.jsonPath();
        String id = responseBody.getString("id");
        String name = responseBody.getString("name");
        System.out.println(id);
        System.out.println(name);

    }
}
