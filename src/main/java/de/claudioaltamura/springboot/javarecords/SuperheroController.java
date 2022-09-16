package de.claudioaltamura.springboot.javarecords;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class SuperheroController {

	private final SuperheroService superHeroService;

	public SuperheroController(SuperheroService superHeroService) {
		this.superHeroService = superHeroService;
	}

	@GetMapping(value="/superheroes",  produces = "application/json")
	public ResponseEntity<List<Superhero>> findAll(){
		return ResponseEntity.ok(superHeroService.findAll());
	}

	@PostMapping(("/superheroes"))
	public ResponseEntity<Superhero> add(@RequestBody Superhero superhero, UriComponentsBuilder uriComponentsBuilder) {

		final var createdSuperhero = superHeroService.add(superhero);

		final var uriComponents =
				uriComponentsBuilder.path("/superheroes/{id}").buildAndExpand(createdSuperhero.id());

		return ResponseEntity.created(uriComponents.toUri()).build();
	}

}