package RestTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Ecommerce {
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	public static String message;
	public static String accessToken;
	@Test(priority = 0 , enabled=false)
	public void signup()
	{
		RestAssured.baseURI =baseurl;
		
	String 	requestbody = "{\n"
			+ "	\"email\": \"malkeet@email.com\",\n"
			+ "	\"password\": \"hello\"\n"
			+ "}";
	
	Response resposne = given()
			.header("Content-Type","application/json")
			.body(requestbody)
			
			.when()
			.post("/user/signup")
			
			.then()
			.assertThat().statusCode(201).contentType(ContentType.JSON)
			.extract().response();
	
	String jsonresponse = resposne.asString();
	//i want to convert the response in to json format
	//why do i use jsonpath to convert the string in to a json format
	JsonPath js = new JsonPath(jsonresponse);
	//nw i have to fetch the id
	message = js.get("message");
	System.out.println(message);
	
	
}


	@Test(priority = 1)
	public void Login()
	{
		RestAssured.baseURI =baseurl;
		
	String 	requestbody = "{\n"
			+ "	\"email\": \"malkeet@email.com\",\n"
			+ "	\"password\": \"hello\"\n"
			+ "}";
	
	Response resposne = given()
			.header("Content-Type","application/json")
			.body(requestbody)
			
			.when()
			.post("/user/login")
			
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();	
	
	String jsonresponse = resposne.asString();
	//i want to convert the response in to json format
	//why do i use jsonpath to convert the string in to a json format
	JsonPath js = new JsonPath(jsonresponse);
	//nw i have to fetch the id
	accessToken = js.get("accessToken");
	System.out.println(accessToken);
	}
}
