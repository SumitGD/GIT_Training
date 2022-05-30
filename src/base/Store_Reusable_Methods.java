package base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Files;

import Files.Payloads;
import Files.ReusableMethods;

public class Store_Reusable_Methods {
	
	public static void main(String[] args) {
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payloads.addPlace())
		
		.when().post("maps/api/place/add/json")
		
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)")
		.extract().response().asString();
		
		//Store Reusable Methods 
		JsonPath js=ReusableMethods.rowToJson(response);
		String placeId=js.getString("place_id");
		System.out.println(placeId);
	}

}
