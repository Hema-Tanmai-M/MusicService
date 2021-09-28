package com.project.music.service.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.project.music.service.model.MusicService;
import com.project.music.service.model.Music;


@RestController

@CrossOrigin

public class MusicController {
	
	@Bean
	public RestTemplate restTemplate()
	{
	 return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{keyword}")
public Object getItems(@PathVariable("keyword") String keyword)
	{
		MusicService user = restTemplate.getForObject("http://api.napster.com/v2.2/search/verbose?" + keyword, MusicService.class);
		return user.getItems().stream().collect(Collectors.toList());
		
		//MusicService user2 = restTemplate.getForObject("https://www.googleapis.com/youtube/v3/search?" + keyword, MusicService.class);
		//return user2.getItems().stream().collect(Collectors.toList());
		
	}

}
