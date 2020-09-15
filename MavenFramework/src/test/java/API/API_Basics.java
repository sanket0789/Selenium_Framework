package API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


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
		.body("{\r\n" + 
				"    \"location\": {\r\n" + 
				"        \"lat\": -38.383494,\r\n" + 
				"        \"lng\": 33.427362\r\n" + 
				"    },\r\n" + 
				"    \"accuracy\": 50,\r\n" + 
				"    \"name\": \"Sanket12\",\r\n" + 
				"    \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"    \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"    \"types\": [\r\n" + 
				"        \"shoe park\",\r\n" + 
				"        \"shop\"\r\n" + 
				"    ],\r\n" + 
				"    \"website\": \"http://google.com\",\r\n" + 
				"    \"language\": \"French-IN\"\r\n" + 
				"}").when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");




	}

}
