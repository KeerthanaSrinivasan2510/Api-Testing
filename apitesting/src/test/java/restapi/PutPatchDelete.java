package restapi;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PutPatchDelete {
	@Test(enabled=false
			)
	public void putMethod() {
		JSONObject request = new JSONObject();
		request.put("name", "Keerthana");
		request.put("job", "senior Tester");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given()
		  .header("Content-Type","application/json")
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(request.toJSONString()).
		when()
		  .put("/users/2").
	    then()
		  .statusCode(200)
		  .log().all();
	}
	@Test(enabled=true)
	public void deleteMethod() {
		baseURI="https://reqres.in/api";
		
		when().
		  delete("/users/2")
		.then()
		 .statusCode(204)
		 .log().all();
	}

}
