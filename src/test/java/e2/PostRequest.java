package e2;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

public class PostRequest {
	@Test(priority = 1)
	public void ApiPostCreateUser() throws IOException, org.json.simple.parser.ParseException{
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(".\\Json\\DataCreateUser.json"); 
		Object obj = json.parse(reader); 
		  
		org.json.simple.JSONObject requestParams = (org.json.simple.JSONObject) obj;
		  
		RestAssured.baseURI = "https://reqres.in/api"; 
		RequestSpecification httpRequest = RestAssured.given()
				.headers("Content-Type", "application/json")
				.body(requestParams.toString());		
		Response response = httpRequest.post("/users");
		  
		String responseBody = response.getBody().asString();
		int responseStatusCode = response.getStatusCode();
		
		Reporter.log("Response body: " + responseBody);
		Reporter.log("Response code: " + String.valueOf(responseStatusCode));
		Reporter.log("Json body: " + requestParams.toString());
		Reporter.log("URL: " + RestAssured.baseURI + "/users");
		
		Assert.assertEquals(responseStatusCode,201);		  
	}		
	
  @Test(priority = 2)
  public void ApiPostRegister() throws IOException, org.json.simple.parser.ParseException{
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader(".\\Json\\DataRegisterSuccessful.json"); 
	  Object obj = json.parse(reader); 
	  
	  org.json.simple.JSONObject requestParams = (org.json.simple.JSONObject) obj;
	  
	  RestAssured.baseURI = "https://reqres.in/api"; 
	  RequestSpecification httpRequest = RestAssured.given()
			  .headers("Content-Type", "application/json")
			  .body(requestParams.toString());
	  
	  Response response = httpRequest.post("/register");
	  
	  String responseBody = response.getBody().asString();
	  int responseStatusCode = response.getStatusCode();
	  
	  Reporter.log("Response body: " + responseBody);
	  Reporter.log("Response code: " + String.valueOf(responseStatusCode));
	  Reporter.log("Json body: " + requestParams.toString());
	  Reporter.log("URL: " + RestAssured.baseURI + "/register");
	  
	  Assert.assertEquals(responseStatusCode,200);	  
  }
    
}
