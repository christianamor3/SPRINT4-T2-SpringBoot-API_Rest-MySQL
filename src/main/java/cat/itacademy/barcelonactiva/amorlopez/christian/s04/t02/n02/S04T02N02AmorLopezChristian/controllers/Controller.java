package cat.itacademy.barcelonactiva.amorlopez.christian.s04.t02.n02.S04T02N02AmorLopezChristian.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.amorlopez.christian.s04.t02.n02.S04T02N02AmorLopezChristian.model.domain.FruitaEntity;
import cat.itacademy.barcelonactiva.amorlopez.christian.s04.t02.n02.S04T02N02AmorLopezChristian.model.services.FruitaEntityServiceImp;


@RestController
@RequestMapping("/fruitaEntity")
public class Controller {
	
	@Autowired
	FruitaEntityServiceImp fruitaEntityServiceImp;
	
	@PostMapping("/add")
	public ResponseEntity<FruitaEntity> createFruitaEntity(@RequestBody FruitaEntity fruita) {
		FruitaEntity fruitaEntity = fruitaEntityServiceImp.save(fruita);
		return ResponseEntity<>(fruitaEntity, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<FruitaEntity> updateFruitaEntity(@PathVariable int id, @RequestBody FruitaEntity fruita) {
		FruitaEntity fruitaEntity = fruitaEntityServiceImp.update(id, fruita);
		
		if (fruitaEntity != null){
			return ResponseEntity<>(fruitaEntity, HttpStatus.OK);
		} else {
			return ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFruitaEntity (@PathVariable int id) {
		fruitaEntityServiceImp.delete(id);
		return ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FruitaEntity>> getAllFruitaEntity() {
		List<FruitaEntity> fruites = fruitaEntityServiceImp.findAll();
		
		if (fruites.isEmpty()){
			return ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity<>(fruites, HttpStatus.OK);	
		}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<FruitaEntity> getOneFruitaEntity (@PathVariable int id){
		FruitaEntity fruitaEntity = fruitaEntityServiceImp.findById(id);
		
		if (fruitaEntity != null){
			return ResponseEntity<>(fruitaEntity, HttpStatus.OK);
		} else {
			return ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	}
	

}
