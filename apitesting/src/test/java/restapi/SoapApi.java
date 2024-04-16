package restapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

public class SoapApi {
	@Test
	public void soapapi() throws IOException {
	File file = new File("./SoapRequest/Add.xml");
	
	if(file.exists())
		System.out.println(">> File Exists");
	
	FileInputStream fileInputStream = new FileInputStream(file);
	String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
	
	baseURI = "http://www.dneonline.com/";
	
	given().contentType("text/xml").
	body(requestBody).
	when().
	post("/calculator.asmx").
	then().
	statusCode(200);
	}
}
