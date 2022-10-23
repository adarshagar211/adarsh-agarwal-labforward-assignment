package com.labforward.scheduler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Value("${file.location}")
	private String filelocation;
	
	@Getter
	private Map<Integer,List<String>> wordMap = new HashMap<Integer,List<String>>();

	// Schedules reading labnotes job for 6 hour
	@Scheduled(fixedRate = 21600000)
	public void scheduleReadingAndCreateWordList() {
		log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		try {
			wordMap = readFileConvertList(filelocation);
		} catch (IOException | URISyntaxException ex) {
			log.error("Error in scheduled job while reading file: {}", ex);
		}
	}
	
	// Reads labnotes file and convert into String array 
	private Map<Integer,List<String>> readFileConvertList(String location) throws IOException, URISyntaxException {
		Map<Integer,List<String>> wordMap =  new HashMap<Integer,List<String>>();
		try (Scanner scanner = new Scanner(ScheduledTasks.class.getClassLoader().getResourceAsStream(location))) {
			int count = 0 ;
			scanner.useDelimiter(Pattern.compile("\n"));
			while(scanner.hasNext())
				wordMap.put(++count, List.of(scanner.next().split("\\s+")));
		}
		return wordMap;
	}
}
