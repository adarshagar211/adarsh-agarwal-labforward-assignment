package com.labforward.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.labforward.scheduler.ScheduledTasks;
import com.labforward.service.DataService;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ScheduledTasks scheduledTasks ; 
    
	@Override
	public long getWordFrequency(String pattern , int labEntryIndex) {
		if (!scheduledTasks.getWordMap().containsKey(labEntryIndex) && scheduledTasks.getWordMap().get(labEntryIndex).isEmpty()) 
			throw new NotFoundException("Word list is empty , please add notes to labnotes file " );
		long frequency = scheduledTasks.getWordMap().get(labEntryIndex).stream()
				                                                       .filter(x -> x.equals(pattern)).count();
		return frequency;
	}

	@Override
	public List<String> getSimilarWords(String pattern , int labEntryIndex) {
		if (!scheduledTasks.getWordMap().containsKey(labEntryIndex) && scheduledTasks.getWordMap().get(labEntryIndex).isEmpty()) 
			throw new NotFoundException("Word list is empty , please add notes to labnotes file " );
		List<String> similarWords = scheduledTasks.getWordMap().get(labEntryIndex).stream()
				                                                                  .filter(x -> !x.equals(pattern) && isSimilarText(x, pattern))
				                                                                  .collect(Collectors.toList());
		return similarWords;
	}

	private static boolean isSimilarText (String source, String destination) {
		int distance = LevenshteinDistance.getDefaultInstance().apply(source, destination);
		return Math.abs(distance) <= 1 ;
	}
	
}
