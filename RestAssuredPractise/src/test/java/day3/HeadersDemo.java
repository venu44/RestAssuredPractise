package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeadersDemo {
	
	
	@Test
	void testHeaders() {
		
		given()
		.when().get("https://www.google.com")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws")
		.log().headers()	;
		
	}

	
	@Test(priority=2)
	void getHeaders() {
		
		Response res= given()
		.when().get("https://www.google.com");
		
		// get single header info
		
		String headerValue =res.getHeader("Content-Type");
		System.out.println(headerValue);
		
	}
	
	//get all headers info
	@Test(priority=3)
	void getAllHeaders() {
		
		Response res= given()
		.when().get("https://www.google.com");
		
		// get single header info
		
		Headers myHeaders =res.getHeaders();
		
		for(Header hd: myHeaders) {
			
			System.out.println("header name is : "+hd.getName() +" header value is :  "+hd.getValue());
			
			
			
		}
		
	
		
	}

}
