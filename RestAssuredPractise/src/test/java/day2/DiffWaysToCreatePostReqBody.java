package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static io.restassured.module.jsv.JsonSchemaValidator.*;
//import static io.restassured.module.xml.XmlPath.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostReqBody {
	
	String id;
	//1 st approach Post body using hashMap
	//@Test(priority=1)
	void testPostUsingHashMap() {
		
		HashMap data=new HashMap();
		data.put("name","suresh5");
		data.put("location","bay");
		data.put("phone","123654");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/store")
		.then()
		.statusCode(201)
		.body("name",equalTo("suresh59"))
		.body("location",equalTo("bay"))
		.body("phone",equalTo("123654"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-type","application/json; charset=utf-8")
.log().all();
	}
	
	
//	
	// 2nd approach @Test(priority=1)
	void testPostUsingJsonLibrary() {
		
		JSONObject data =new JSONObject();
		data.put("name","suresh5");
		data.put("location","bay");
		data.put("phone","123654");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name",equalTo("suresh5"))
		.body("location",equalTo("bay"))
		.body("phone",equalTo("123654"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-type","application/json; charset=utf-8")
.log().all();
	}
	
	
	//3 rd approach post body using pojo class
//	@Test(priority=1)
	void testPostUsingPojo() {
		
		Pojo_PostRequest data= new Pojo_PostRequest();
		data.setNames("suresh6");
		data.setLocation("hyd");
		data.setPhone("654123");
		
		String coursesArr[]= {"c","c++ruby"};
		data.setCourses(coursesArr);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name",equalTo("suresh5"))
		.body("location",equalTo("bay"))
		.body("phone",equalTo("123654"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-type","application/json; charset=utf-8")
.log().all();
	}
	
	
	//4th approach post using external json file
	@Test(priority=1)
	void testPostUsingJson() throws FileNotFoundException {
		
		File f = new File (".\\body.json");
		FileReader fr= new FileReader(f);
		
		JSONTokener jt =new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
		
		id= given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.jsonPath().get("id");
		System.out.println("newly created id is:" +id);
		
		
		given()
		.then()
		.statusCode(201)
		.body("name",equalTo("suresh58"))
		.body("location",equalTo("bayhyd"))
		.body("phone",equalTo("123654"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-type","application/json; charset=utf-8")
.log().all();
	}
	
	@Test(priority=2)
	void testDelete() {
		given()
		.when()
		.delete("http://localhost:3000/Students/"+id)
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
