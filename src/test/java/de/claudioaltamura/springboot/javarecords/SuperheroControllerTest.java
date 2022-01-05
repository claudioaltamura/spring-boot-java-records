package de.claudioaltamura.springboot.javarecords;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = SuperheroController.class)
class SuperheroControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SuperHeroService superHeroService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void whenGetThenReturns200() throws Exception {
		mockMvc.perform(get("/superheroes")
						.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	void whenValidInputThenReturns200() throws Exception {
		final var city = new City(1L, "New York", "NYC");
		final var superhero = new Superhero(1L, "Spiderman", "Peter Parker", 89.0D, city);

		mockMvc.perform(post("/superheroes")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(superhero)))
				.andExpect(status().isMethodNotAllowed());
	}
}