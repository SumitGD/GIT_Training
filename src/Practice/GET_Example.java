package Practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_Example {

	//http://rahulshettyacademy.com/maps/api/place/get/json?place_id=cbeef2741cce7486303e61bbc3df2945&key=qaclick123
	public static void getPlace() {
		RestAssured.baseURI="http://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", POST_Example.AddPlace())

		.when().get("maps/api/place/get/json")

		.then().log().all().assertThat().statusCode(200);

	}


	public static void main(String[] args) {
		GET_Example.getPlace();
	}



}



  