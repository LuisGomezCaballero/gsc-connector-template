/**
 * 
 */
package net.atos.mcs.gscconnectortemplate.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Luis
 *
 */
@WebMvcTest
class TemplateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

		mockMvc.perform(get("/helloWorld").contentType("application/json")).andExpect(status().isOk());

	}

}
