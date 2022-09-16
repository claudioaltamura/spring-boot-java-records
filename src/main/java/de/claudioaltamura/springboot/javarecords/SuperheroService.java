package de.claudioaltamura.springboot.javarecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class SuperheroService {

	private final CityService cityService;
	private final Map<Long, Superhero> superheroes = new ConcurrentHashMap<>();
	private final AtomicLong superHeroKey = new AtomicLong(1);

	public SuperheroService(CityService cityService) {
		this.cityService = cityService;
	}

	public List<Superhero> findAll() {
		return new ArrayList<>(superheroes.values());
	}

	public Superhero add(Superhero superhero) {
		final Long id = superHeroKey.getAndIncrement();
		final Optional<City> city = cityService.findById(superhero.city().id());
		final var createdSuperhero = new Superhero(id, superhero.name(), superhero.realName(), superhero.power(), city.orElseThrow());
		superheroes.put(id,createdSuperhero);
		return createdSuperhero;
	}

	public void delete(Long superheroId) {
		superheroes.remove(superheroId);
	}
}
