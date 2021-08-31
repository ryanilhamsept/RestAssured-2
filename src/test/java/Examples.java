import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {
	
	@Test
	public void test_get () {
		
		baseURI = "http://localhost:3004/" ;
		given().
			
			//param("name", "Automation").
			get("/users").
		then().
			statusCode(200).
			log().all();
		
	}
	
//	@Test
//	public void test_post () {
//		
//		JSONObject  request = new JSONObject ();
//		request.put("firstName", "Loki");
//		request.put("lastname", "Loki");
//		request.put("subjectId", 2);
//		
//		
//		baseURI = "http://localhost:3004/" ;
//		
//		given().
//			header("Content-Type","application/json").
//			contentType(ContentType.JSON).
//			accept(ContentType.JSON).
//			body(request.toJSONString()).
//		when().
//			post("/users").
//		then().
//			statusCode(500).
//			log().all();
//	}
	
	
	@Test
	public void test_patch () {
		
		JSONObject  request = new JSONObject ();

		request.put("lastName", "Loki");
	
		
		baseURI = "http://localhost:3004/" ;
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_put() {
		
		JSONObject  request = new JSONObject ();

		request.put("firstName", "Mary");
		request.put("lastname", "Jane");
		request.put("subjectId", 2);
	
		
		baseURI = "http://localhost:3004/" ;
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/3").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3004/" ;
		
		when().
			delete("/users/5").
		then().
			statusCode(200).
			log().all();
	}
	

}
