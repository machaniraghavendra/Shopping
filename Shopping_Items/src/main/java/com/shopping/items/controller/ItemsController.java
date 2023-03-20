package com.shopping.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.items.entity.ItemEntity;
import com.shopping.items.exception.ItemAlreadyException;
import com.shopping.items.exception.ItemNotFoundException;
import com.shopping.items.service.ItemService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/items/")
@Api(tags="Items" , description = "Gives all items data")
public class ItemsController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody ItemEntity itemEntity) throws ItemAlreadyException{
		return new ResponseEntity<String>(itemService.save(itemEntity),HttpStatus.OK);
	}
	
	@PostMapping("/all")
	@ResponseBody
	public ResponseEntity<String> saveall(@RequestBody List<ItemEntity> itemEntity) throws ItemAlreadyException{
		return new ResponseEntity<String>(itemService.saveAll(itemEntity),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody ItemEntity itemEntity) throws ItemNotFoundException{
		return new ResponseEntity<String>(itemService.update(itemEntity),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int itemId) throws ItemNotFoundException{
		return new ResponseEntity<String>(itemService.delete(itemId),HttpStatus.OK);
	}
	@DeleteMapping("/")
	public ResponseEntity<String> deleteAll() throws ItemNotFoundException{
		return new ResponseEntity<String>(itemService.deleteAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Object>> find(@PathVariable("id") int itemId) throws ItemNotFoundException{
		return new ResponseEntity<List<Object>>(itemService.find(itemId),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ItemEntity>> viewall(){
		return new ResponseEntity<List<ItemEntity>>(itemService.viewall(),HttpStatus.OK);
	}
}
