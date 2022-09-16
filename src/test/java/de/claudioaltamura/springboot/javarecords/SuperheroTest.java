package de.claudioaltamura.springboot.javarecords;

import static de.claudioaltamura.springboot.javarecords.SuperHeroesDataProvider.createSuperhero;
import static de.claudioaltamura.springboot.javarecords.SuperHeroesDataProvider.createSuperheroWithoutId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SuperheroTest {

	@Test
	void testCreate(){
		final Superhero superhero = createSuperhero();
		assertThat(superhero.name()).isEqualTo("Spiderman");
	}

	@Test
	void testCreateWithoutId(){
		final Superhero superhero = createSuperheroWithoutId();
		assertThat(superhero.id()).isNull();
		assertThat(superhero.name()).isEqualTo("Spiderman");
	}


	@Test
	void testToString(){
		final Superhero superhero = createSuperhero();
		assertThat(superhero.toString()).hasToString("Superhero[id=1, name=Spiderman, realName=Peter Parker, power=98.0, city=City[id=1, name=New York, code=NYC]]");
	}

}