package day4;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;
public class ParsingJsonResponseData {
	
	//@Test
	void testJsonResponse() {
		
		
		// Approach 1
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/students")
		
		
		.then()
		.statusCode(200)
		.header("Content-type", "application/json; charset=utf-8")
		.body("[4].courses[0]",equalTo("c"));
		
		
		
	}

	
	//@Test(priority=2)
	void TestJsonREsponse2() {
		
		Response res=given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/students");
		
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		
		String BookName= res.jsonPath().get("[4].courses[0]").toString();
		Assert.assertEquals(BookName, "c");
		
	}
	
	@Test(priority=1)
		 void JsonbjectEx() {
			
			Response res=given()
					.contentType(ContentType.JSON)
					.when()
					.get("http://localhost:3000/Students");
			System.out.println("test print");
			
			String responseString = res.toString();
		    System.out.println("Response String: " + responseString);
			
			JSONObject jo = new JSONObject(responseString);
			
			for(int i=0;i<jo.getJSONArray("Students").length();i++) {
				
				String name= jo.getJSONArray("Students").getJSONObject(i).get("name").toString();
				System.out.println(name);
				
			}
			
		}
	
	
}
