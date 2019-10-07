package com.beerhouse.controller;

import java.net.URI;
import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.beerhouse.entity.Beer;
import com.beerhouse.service.BeerService;

@Controller
@RequestMapping("/")
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping("beers")
	public ResponseEntity<List<Beer>> getBeers() {	
		
		List<Beer> beers = new ArrayList<Beer>();
		
		beers.addAll(beerService.findAll());
		
		return ResponseEntity.ok().body(beers);
	}	
	
	@PostMapping("beers")
	public ResponseEntity<Void> addBeer(@Valid @RequestBody Beer beer){		
		beer = beerService.add(beer);
		
		final URI location = ServletUriComponentsBuilder
	            .fromCurrentServletMapping().path("/beers/{id}").build()
	            .expand(beer.getId()).toUri();

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(location);
		
	    final ResponseEntity<Void> entity = new ResponseEntity<Void>(headers,
	          HttpStatus.CREATED);
	    
	    return entity;
	}
	
	@GetMapping("beers/{id}")
	public ResponseEntity<Beer> searchBeear(@PathVariable("id") Integer pinId)
			throws ResourceNotFoundException {
		 return ResponseEntity.ok().body(beerService.findById(pinId));
	}
	
	@PutMapping("beers/{id}")
	public ResponseEntity<Beer> updateBeer(@PathVariable(value = "id") Integer pinId,
		@Valid @RequestBody Beer beerUpdate) throws ResourceNotFoundException {
     	
		try{
			beerUpdate = beerService.updatePutById(pinId, beerUpdate);
		}catch (ResourceNotFoundException e) {
			new ResourceNotFoundException("Beer not found, id " + pinId, (Resource) e);
		}
		return ResponseEntity.ok(beerUpdate);
    }

	@PatchMapping("beers/{id}")
	public ResponseEntity<Beer> updatePatchBeer(@PathVariable("id") Integer pinId,
		@Valid @RequestBody Beer beerPatch)  
		throws ResourceNotFoundException{
		
		beerPatch = beerService.updatePatchById(pinId, beerPatch);
		
		return ResponseEntity.ok(beerPatch);
	}
	
	@DeleteMapping("beers/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("id") Integer pinId)
			throws ResourceNotFoundException {
		
		try {
			beerService.remove(pinId);
		}catch (ResourceNotFoundException e) {
			new ResourceNotFoundException("Beer not found, id " + pinId, (Resource) e);
		}
	}
	
}
