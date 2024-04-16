package restapi;

import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class jsonschemavalidator {
	
	@Test
	public void getmethodbdd() {
		given()
		.baseUri("https://reqres.in")
		.when()
		.get("/api/users?page=2")
		.then()
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json.txt"));
		
	}

}
