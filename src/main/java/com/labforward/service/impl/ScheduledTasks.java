package com.labforward.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Value("${labfile.location.name}")
	private String filelocation;
	
	@Getter
	private List<String> wordList = new ArrayList<String>();

	// Schedules reading labnotes job for 6 hour
	@Scheduled(fixedRate = 21600000)
	public void scheduleReadingAndCreateWordList() {
		log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		try {
			  wordList = readFileConvertList(filelocation);
		} catch (IOException | URISyntaxException ex) {
			log.error("Error in scheduled job while reading file: {}", ex);
		}
	}
	
	// Reads labnotes file and convert into String array 
	private List<String> readFileConvertList(String location) throws IOException, URISyntaxException {
		List<String> result = null;
		try (Stream<String> lines = Files.lines(Path.of(ClassLoader.getSystemResource(location).toURI()))) {

			result = lines.flatMap(Pattern.compile("\\s+")::splitAsStream).collect(Collectors.toList());
		}
		return result;
	}
}
