package day6;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.json.JSONObject;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class JsonSchemaValidations {

	
	@Test
	void JsonSchemaValidation() {
		
		
		//RestAssuredConfig config = RestAssured.config()
      //          .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StoreJsonSchema.json"));
		
		
	}
}
