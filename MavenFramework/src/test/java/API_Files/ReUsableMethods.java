package API_Files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	public static JsonPath rawToJson(String response) 
	
	{
		JsonPath Js1 = new JsonPath(response);
		return Js1;
	}
	
}
