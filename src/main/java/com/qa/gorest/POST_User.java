package com.qa.gorest;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class POST_User {
	public static int userId;
	public static void main(String[] args) {
		Faker faker=new Faker();
		POJO_User user=new POJO_User();
		
		user.setName(faker.name().username());
		user.setEmail(faker.internet().emailAddress());
		user.setGender("male");
		user.setStatus("active");
		
		
		Response postResponse = given().baseUri("https://gorest.co.in/public/v2/users")
		.header("Authorization","Bearer e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6")
		.contentType(io.restassured.http.ContentType.JSON)
		.body(user)
		.log().all()
		.when().post()
		.then().log().all()
		.extract().response();
		
		 int id = postResponse.jsonPath().getInt("id");
		 System.out.println("Created User ID: " + id);
		 POST_User.userId=id;
	}
	

}
