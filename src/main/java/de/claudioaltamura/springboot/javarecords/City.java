package de.claudioaltamura.springboot.javarecords;

import java.util.Objects;

public record City(Long id, String name, String code) {

	public City (String name, String code) {
		this(null, name, code);
	}
	public City {
		Objects.requireNonNull(code);
		Objects.requireNonNull(code);
	}

}
