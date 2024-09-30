package day3;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesDemo {
	@Test(priority=1)
	void testCookies(){
		
		given()
		.when()
		.get("https://www.google.com")
		.then()
		.cookie("AEC", "Ad49MVGjloluOhO1oYeF52g7Z-VXCe1Cd-2s8t18k-Np_2G4ik3e9up5dt4")
		.log().all();
		
	}
	
	@Test(priority=2)
	void getCookieInfo() {
		
		Response res=given()
		.when()
		.get("https://www.google.com")
		;
		
		
		// To capture single cookie value
		String cookie_Value =res.getCookie("AEC");
		System.out.println(cookie_Value);
		
		
		//2nd way to get all cookies 
		
		Map<String,String> cookies_values=res.getCookies();
		
		System.out.println(cookies_values.keySet());
		
		for(String k : cookies_values.keySet()) {
			
			String cookie_value=res.getCookie(k);
			System.out.println(k + "     "+ cookie_value);
			
		}
		
	
		
	}
	
}