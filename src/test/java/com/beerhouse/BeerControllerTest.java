package com.beerhouse;

import static org.junit.Assert.*;

import javax.annotation.meta.When;

import org.junit.Assert;
import org.junit.Before;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.beerhouse.controller.BeerController;
import com.beerhouse.entity.Beer;
import com.beerhouse.service.BeerService;


public class BeerControllerTest {

	
	private BeerService beerService;
	private BeerController beerController;
	
	@Before
	public void init(){
		beerService = Mockito.mock(BeerService.class);
		MockitoAnnotations.initMocks(this);
	} 
	
	@Test
	public void addBeer(){
	
		@Test
		/*Chama o serviço pelo metodo POST*/
		public void testCriaUsuario() {
			String json = "{   \r\n" + 
						  "    \"id\": 1,\r\n" + 
						  "    \"name\": \"cerveja 01\",\r\n" + 
						  "    \"ingredients\": \"agua, lupulo\",\r\n" + 
						  "    \"alcoholContent\": \"Sim\",\r\n" + 
						  "    \"price\": 2.99,\r\n" + 
						  "    \"category\": \"Normal\"\r\n" + 
						  "}";
	    	
	         given()
	           .contentType("application/json")
	    	   .body(myJson)
	    	 .when()
	    	   .post("/")
	    	 .then()
	    	   .statusCode(200)
	    	   .body("message", containsString("User created successfully"));	 
		}
		
	}
	
}
