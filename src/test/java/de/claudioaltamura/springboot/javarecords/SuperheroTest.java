package de.claudioaltamura.springboot.javarecords;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SuperheroTest {

	private Superhero createSuperhero() {
		return new Superhero(1L, "Spiderman", "Peter Parker", 98.0D, new City(1L, "New York", "NYC"));
	}

	@Test
	void testCreate(){
		final Superhero superhero = createSuperhero();
		assertThat(superhero.name()).isEqualTo("Spiderman");
	}

	@Test
	void testToString(){
		final Superhero superhero = createSuperhero();
		assertThat(superhero.toString()).hasToString("Superhero[id=1, name=Spiderman, realName=Peter Parker, power=98.0, city=City[id=1, name=New York, code=NYC]]");
	}

}