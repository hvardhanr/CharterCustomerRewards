package com.charter.clientrewards.controller;

import com.charter.clientrewards.ExceptionHandling.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.charter.clientrewards.pojo.RewardsSummary;
import com.charter.clientrewards.service.RewardsSummaryService;

@RestController
public class RewardsController {

	Logger logger = LoggerFactory.getLogger(RewardsController.class);
	
	@Autowired
	private RewardsSummaryService rewardsSummaryService;
	
	@GetMapping("/getRewardsSummary/{id}")
	public ResponseEntity<RewardsSummary> getRewardsById(@PathVariable Integer id) {
		logger.info("Entered the get rewards summary");
		RewardsSummary rewardsSummary = rewardsSummaryService.calculateRewardsSummary(id);

		//If no object is returned, throw a custom exception
		if(rewardsSummary == null){
			logger.error("Customer Object is empty/No Customer found");
			throw new CustomerNotFoundException("Customer id '" + id + "' does not exist");
		}

		return new ResponseEntity<RewardsSummary>(rewardsSummary, HttpStatus.OK);
	}

}
