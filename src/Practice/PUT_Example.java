package Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import Files.Payloads;

public class PUT_Example {
	//http://rahulshettyacademy.com/maps/api/place/get/json?place_id=cbeef2741cce7486303e61bbc3df2945&key=qaclick123
	public static void updatePlace() {
		RestAssured.baseURI="http://rahulshettyacademy.com";

		given().queryParam("key", "qaclick123").queryParam("place_id", Practice.POST_Example.AddPlace())
		.header("Content-Type","application/json")
		.body(Payloads.updatePlace())

		.when().put("maps/api/place/get/json")
		
		.then().log().all().assertThat().statusCode(200);
		
		
	}
	
	public static void main(String[] args) {
		updatePlace();
	}
}
