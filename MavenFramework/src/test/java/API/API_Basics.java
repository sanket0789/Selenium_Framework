package API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;


public class API_Basics {

	public static void main(String[] args) {

		Add_Place_API();
	}

	public static void Add_Place_API() {

		//Validate if Add Place API is working as expected.

		//Rest Assurad API works on below 3 principals.
		//Given - all input details
		//When - Submit API
		//Then - Validate the responce.

		RestAssured.baseURI="https://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.Add_Place()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");




	}

}
