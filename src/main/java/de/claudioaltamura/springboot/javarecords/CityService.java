package de.claudioaltamura.springboot.javarecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class CityService {

	private final Map<Long, City> cities = new ConcurrentHashMap<>();
	private final AtomicLong cityKey = new AtomicLong(1);

	public List<City> findAll() {
		return new ArrayList<>(cities.values());
	}

	public Optional<City> findById(Long cityId) {
		return Optional.ofNullable(cities.get(cityId));
	}

	public City add(City city) {
		final Long id = cityKey.getAndIncrement();
		final var createdCity = new City(id, city.name(), city.code());
		cities.put(id, createdCity);
		return createdCity;
	}

	public void delete(Long cityId) {
		cities.remove(cityId);
	}
}
