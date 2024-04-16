package restapi;
import org.testng.Assert;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetMethod {
	@Test(enabled=true)
	public void getmethodnonbdd() {
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
	}
	
	@Test(enabled=false)
	public void getmethodbdd() {
		given()
		.baseUri("https://reqres.in/")
		.when()
		.get("api/users?page=2")
		.prettyPrint();
	}

}
