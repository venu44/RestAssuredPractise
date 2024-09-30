package day6;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.Pojo_PostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//   POJO---Serilize---JSON------Deserilize---POJO
public class SerilizationDeserilization {
	//pojo to json , serilization process
	@Test
	
void ConvertPojo2Json() throws JsonProcessingException {
		
		
		
		Student StuPojo= new Student();
		StuPojo.setNames("suresh6");
		StuPojo.setLocation("hyd");
		StuPojo.setPhone("654123");
		
		String coursesArr[]= {"c","c++ruby"};
		StuPojo.setCourses(coursesArr);
		
		// need to import ObjectMapper form jackson.databinder only not from restAssured.io
		ObjectMapper ObjMapper=new ObjectMapper();
		
		String JsonData=ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(StuPojo);
		
	System.out.println(JsonData);
	}

	
	//json to pojo , deserilization
	
	@Test
	void Json2Pojo() throws  JsonProcessingException {
		
		String JsonData= "{\r\n"
				+ "  \"names\" : \"suresh6\",\r\n"
				+ "  \"location\" : \"hyd\",\r\n"
				+ "  \"phone\" : \"654123\",\r\n"
				+ "  \"courses\" : [ \"c\", \"c++ruby\" ]\r\n"
				+ "}";
		
		
		ObjectMapper objMapper =new ObjectMapper();
		
		Student stuPojo =objMapper.readValue(JsonData, Student.class);
		System.out.println(stuPojo.getPhone());
		System.out.println(stuPojo.getLocation());
		System.out.println(stuPojo.getNames());
		System.out.println(stuPojo.getCourses()[0]);
		System.out.println(stuPojo.getCourses()[1]);
		
		
	}
}
