package com.labforward.controller;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.service.DataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "${crossorigin.url}")
@RequestMapping("/api/data")
@Validated
public class DataController {

	@Autowired
	private DataService dataService;

	@GetMapping("/frequency/{pattern}")
	public long getWordFrequency(@PathVariable @Size (min = 1 , message="Please enter any input") 
			                                   @Pattern(regexp = "^\\w+" , message = "Please enter valid input")  
	                                           String pattern) {
		log.info("Getting frequency of words in dictionary ");
		return dataService.getWordFrequency(pattern);
	}

	@GetMapping("/similar/{pattern}")
	public List<String> getSimilarWords(@PathVariable @Size (min = 1 , message="Please enter any input") 
                                                      @Pattern(regexp = "^\\w+" , message = "Please enter valid input")  
	                                                  String pattern) {
		log.info("Getting similar words from dictory ");
		return dataService.getSimilarWords(pattern);
	}

}
