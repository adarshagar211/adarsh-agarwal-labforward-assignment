package com.labforward.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DataService {

	public long getWordFrequency(String word) ;

	public List<String> getSimilarWords(String word); 

}
