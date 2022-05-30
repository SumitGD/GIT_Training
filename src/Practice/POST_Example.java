package Practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import Files.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class POST_Example {
	
	public static void main(String[] args) {
	
		AddPlace();
		
	}
	
	public static String AddPlace() {
	RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payloads.addPlace())
		
		.when().post("maps/api/place/add/json")
		
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)")
		.extract().response().asString();
		
		JsonPath js= new JsonPath(response);
		String placeId=js.getString("place_id");
	//	System.out.println(placeId);
		return placeId;
		
	}

}
