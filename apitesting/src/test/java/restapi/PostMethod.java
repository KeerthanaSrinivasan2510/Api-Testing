package restapi;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostMethod {
	@Test
	public void postMethod() {
		Map<String, Object> map = new HashMap<String,Object>();
		//map.put("name","keerthi");
		//map.put("job", "Tester");
		JSONObject request = new JSONObject();
		request.put("name", "Keerthi");
		request.put("job", "Tester");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given()
		  .header("Content-Type","application/json")
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(request.toJSONString()).
		when()
		  .post("/users").
	    then()
		  .statusCode(201)
		  .log().all();
		
		
	}
	

	
}
