package com.beerhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.entity.Beer;
import com.beerhouse.repository.BeerRepository;

@Service
public class BeerService {
	
	@Autowired
	private BeerRepository beerRepository;
	
	public void remove(Integer pinId){
		Beer beer = beerRepository.findOne(pinId);
		beerRepository.delete(beer);
	}
	
	public Beer updatePutById(Integer pinId, Beer beerUpdate){
		
		Beer beer = beerRepository.findOne(pinId);
		
		if (beer != null) {
			return beerRepository.saveAndFlush(beerUpdate);
		}
		return null;
	}
	
	public Beer add(Beer beer) {
		return beerRepository.saveAndFlush(beer);	
	}
	
	public List<Beer> findAll(){
		return beerRepository.findAll();
	}
	
	public Beer findById(Integer pinId){
		return beerRepository.findOne(pinId);
	}
	
	public Beer updatePatchById(Integer pinId, Beer beerUpdate){
		
		Beer beer = beerRepository.findOne(pinId);
		
		beer.setName((beer.getName() != beerUpdate.getName() ? beerUpdate.getName() : beer.getName()));
		beer.setIngredients((beer.getIngredients() != beerUpdate.getIngredients() ? beerUpdate.getIngredients() : beer.getIngredients()));
		beer.setAlcoholContent((beer.getAlcoholContent() != beerUpdate.getAlcoholContent() ? beerUpdate.getAlcoholContent() : beer.getAlcoholContent()));
		beer.setCategory((beer.getCategory() != beerUpdate.getCategory() ? beerUpdate.getCategory() : beer.getCategory()));
		beer.setPrice((beer.getPrice() != beerUpdate.getPrice() ? beerUpdate.getPrice() : beer.getPrice()));
		
		return beerRepository.saveAndFlush(beer);	
	}
}
