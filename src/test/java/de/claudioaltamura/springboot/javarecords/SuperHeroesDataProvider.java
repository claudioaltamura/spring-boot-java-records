package de.claudioaltamura.springboot.javarecords;

class SuperHeroesDataProvider {

   static Superhero createSuperhero() {
    return new Superhero(1L, "Spiderman", "Peter Parker", 98.0D, new City(1L, "New York", "NYC"));
  }

   static Superhero createSuperheroWithoutId() {
    return new Superhero("Spiderman", "Peter Parker", 98.0D, new City(1L, "New York", "NYC"));
  }

}
