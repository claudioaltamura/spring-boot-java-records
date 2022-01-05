package de.claudioaltamura.springboot.javarecords;

import java.util.Objects;

public record City(Long id, String name, String code) {
	public City {
		Objects.requireNonNull(id);
		Objects.requireNonNull(name);
		Objects.requireNonNull(code);
	}
}
