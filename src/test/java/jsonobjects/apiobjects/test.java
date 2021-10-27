package jsonobjects.apiobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class test {

    private static final String CAT_PATH = "src/test/resources/cat.json";
    private static final String addPlace_PATH = "src/test/resources/addPlace.json";

    public static void main(String[] args) throws IOException {

        jsonHelper.getObjectFromJson("addPlace");
        AddPlace addPlace = new jsonHelper().getAddPlace("addPlace");

        String json = jsonHelper.readJson(addPlace_PATH);
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Response res =given().log().all().queryParams("key", "qaclick123")
                .body(json)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(res.asString());
    }
}
