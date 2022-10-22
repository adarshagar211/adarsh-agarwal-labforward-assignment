package com.labforward.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.labforward.controller.DataController;
import com.labforward.service.DataService;

@WebMvcTest(controllers = { DataController.class })
@AutoConfigureMockMvc
public class DataAppControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DataService dataService;

	@Test
	public void testGetFrequencyEndpoint() throws Exception {
		when(dataService.getWordFrequency(Mockito.anyString())).thenReturn(2l);
		this.mockMvc.perform(get("/api/data/frequency/word")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("2"));
	}

	@Test
	public void testGetSimilarWordsEndpoint() throws Exception {
		List<String> listSimilarWords = List.of("test");
		when(dataService.getSimilarWords(Mockito.anyString())).thenReturn(listSimilarWords);
		this.mockMvc.perform(get("/api/data/similar/word")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0]").value("test"));
	}

	@Test
	public void testGetFrequencyEndpointInvalidInput() throws Exception {
		this.mockMvc.perform(get("/api/data/frequency/@$%")).andDo(print()).andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$['getWordFrequency.pattern']").value("Please enter valid input"));
	}

	@Test
	public void testGetSimilarWordsEndpointInvalidInput() throws Exception {
		this.mockMvc.perform(get("/api/data/similar/@#")).andDo(print()).andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$['getSimilarWords.pattern']").value("Please enter valid input"));
	}

}