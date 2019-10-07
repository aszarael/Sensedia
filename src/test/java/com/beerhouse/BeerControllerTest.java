package com.beerhouse;

import static com.jayway.restassured.RestAssured.*;
import org.junit.Test;

public class BeerControllerTest {

	
	@Test
	public void addBeer(){
		
		String json = "{   \r\n" + 
		    		  "    \"id\": 1,\r\n" + 
					  "    \"name\": \"cerveja 01\",\r\n" + 
					  "    \"ingredients\": \"agua, lupulo\",\r\n" + 
					  "    \"alcoholContent\": \"Sim\",\r\n" + 
					  "    \"price\": 2.99,\r\n" + 
					  "    \"category\": \"Normal\"\r\n" + 
					  "}";
		
		String location = "http://localhost:9000/beerhouse/beers/1";
	    	
	    given()
	          .contentType("application/json")
	          .body(json)
	    	  .when()
	    	  .post("/")
	    	  .then()
	    	  .statusCode(201)
	    	  .header("Location", location); 
		
	}
	
}
