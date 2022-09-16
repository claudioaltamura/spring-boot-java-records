package de.claudioaltamura.springboot.javarecords;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@WebMvcTest(controllers = SuperheroController.class)
class SuperheroControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SuperheroService superHeroService;

	@MockBean
	private CityService cityService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void whenGetThenReturns200() throws Exception {
		List<Superhero> list = List.of(SuperHeroesDataProvider.createSuperhero());
		when(superHeroService.findAll()).thenReturn(list);
		mockMvc.perform(get("/superheroes"))
						.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	void whenValidInputThenReturns200() throws Exception {
		final var createdCity = new City(1L, "New York", "NYC");
		final var createdSuperhero = new Superhero(1L, "Spiderman", "Peter Parker", 89.0D, createdCity);
		when(superHeroService.add(any(Superhero.class))).thenReturn(createdSuperhero);

		final var newCity = new City("New York", "NYC");
		final var newSuperhero = new Superhero("Spiderman", "Peter Parker", 89.0D, newCity);

		mockMvc.perform(post("/superheroes")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(newSuperhero)))
				.andExpect(status().isCreated());
	}
}