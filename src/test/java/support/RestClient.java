package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private String loginToken;

    public void login (Map<String, String> user )
    {
        //prepare!
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(user);

        Response responce = request.post();

        //extract data
        Map <String, Object> result = responce.then().statusCode(200).extract().jsonPath().getMap("");

        loginToken = "Bearer " + result.get("token");
        System.out.println(loginToken);

    }
}
