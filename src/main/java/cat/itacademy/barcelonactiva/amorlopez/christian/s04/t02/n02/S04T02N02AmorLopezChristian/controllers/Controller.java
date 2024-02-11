package cat.itacademy.barcelonactiva.amorlopez.christian.s04.t02.n02.S04T02N02AmorLopezChristian.controllers;

import java.util.List;

import java.util.Optional;
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
		return ResponseEntity.status(HttpStatus.CREATED).body(fruitaEntity);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<FruitaEntity> updateFruitaEntity(@PathVariable int id, @RequestBody FruitaEntity fruita) {
		FruitaEntity fruitaEntity = fruitaEntityServiceImp.update(id, fruita);
		
		if (fruitaEntity != null){
			return ResponseEntity.status(HttpStatus.OK).body(fruitaEntity);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFruitaEntity (@PathVariable int id) {
		String mensaje = fruitaEntityServiceImp.delete(id);
			
		return ResponseEntity.ok(mensaje);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FruitaEntity>> getAllFruitaEntity() {
		List<FruitaEntity> fruites = fruitaEntityServiceImp.findAll();
		
		if (fruites.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(fruites);
		}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<FruitaEntity> getOneFruitaEntity (@PathVariable int id){
		Optional<FruitaEntity> fruitaEntityOptional = fruitaEntityServiceImp.findById(id);
		
		if (fruitaEntityOptional.isPresent()){ // Optional sirve para saber si es o no nulo.
			return ResponseEntity.status(HttpStatus.OK).body(fruitaEntityOptional.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	}
	
