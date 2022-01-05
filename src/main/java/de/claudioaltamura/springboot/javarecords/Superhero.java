package de.claudioaltamura.springboot.javarecords;

import java.util.Objects;

public record Superhero(Long id, String name, String realName, Double power, City city) {
	public Superhero {
		Objects.requireNonNull(id);
		Objects.requireNonNull(name);
		Objects.requireNonNull(realName);
		Objects.requireNonNull(power);
		Objects.requireNonNull(city);
	}
}
