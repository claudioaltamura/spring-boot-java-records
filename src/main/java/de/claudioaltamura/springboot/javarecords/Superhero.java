package de.claudioaltamura.springboot.javarecords;

import java.util.Objects;

public record Superhero(Long id, String name, String realName, Double power, City city) {

	/**
	 * New constructor with different arguments.
	 * @param name name
	 * @param realName realName
	 * @param power power
	 * @param city city
	 */
	public Superhero(String name, String realName, Double power, City city) {
		this(null, name, realName, power, city);
	}

	/**
	 * Public constructor ensuring fields are not null.
	 * @param id id
	 * @param name name
	 * @param realName realName
	 * @param power power
	 * @param city city
	 */
	public Superhero {
		Objects.requireNonNull(name);
		Objects.requireNonNull(realName);
		Objects.requireNonNull(power);
		Objects.requireNonNull(city);
	}

	/**
	 * Static factory method.
	 * @param name name
	 * @param realName realName
	 * @param power power
	 * @param city city
	 * @return new Superhero.
	 */
	public static Superhero of(String name, String realName, Double power, City city) {
		return new Superhero(name, realName, power, city);
	}

	public static Superhero of(Long id, String name, String realName, Double power, City city) {
		Objects.requireNonNull(id);
		return new Superhero(id, name, realName, power, city);
	}

}
