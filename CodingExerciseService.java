package com.service;

import org.springframework.stereotype.Service;

@Service
public class CodingExerciseService implements ICodingExerciseService {
	
	public String addNumbers(int actualResult, int humanResult) {
	
		System.out.println("CodingExerciseService actualResult--->"+actualResult);
		System.out.println("CodingExerciseService humanResult--->"+humanResult);

		if (actualResult == humanResult)
		{
			return "You are a Human";
		}
		else
		{
			return "You are a Bot Not a Human. Please Try again...!";
		}
	}
}