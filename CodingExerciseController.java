package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ICodingExerciseService;


@Controller
@RequestMapping(value="/humanCheck")
public class CodingExerciseController {

	@Autowired
	ICodingExerciseService codingExerciseService;
	

	public ICodingExerciseService getCodingExercise() {
		return codingExerciseService;
	}

	public void setCodingExercise(ICodingExerciseService codingExerciseService) {
		this.codingExerciseService = codingExerciseService;
	}

	int randomNumber1;
	int randomNumber2;
	int randomNumber3;
	
	@RequestMapping(value="/genNumbers", method=RequestMethod.GET)
	public @ResponseBody String generateNumbers()
	{
		randomNumber1 = (int)(Math.random() * 10 + 1);
		randomNumber2 = (int)(Math.random() * 10 + 1);
		randomNumber3 = (int)(Math.random() * 10 + 1);
		String genertedNos = "Please sum the numbers--->"+ randomNumber1 + " , " + randomNumber2 + " , " + randomNumber3;

		System.out.println("success--> three nos" + randomNumber1 + randomNumber2 + randomNumber3);
		System.out.println("success--> genertedNos" + genertedNos);
		return genertedNos;
	}
	
	@RequestMapping(value = "/addNumbers", method = RequestMethod.GET)
	public @ResponseBody String addNumbers(@RequestParam int humanResult)
	{
		int actualResult = randomNumber1 + randomNumber2 + randomNumber3;
		System.out.println("actualResult--->"+actualResult);
		System.out.println("humanResult--->"+humanResult);
		return codingExerciseService.addNumbers(actualResult, humanResult);
	}
}
