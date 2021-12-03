package com.charter.clientrewards.service;

import java.util.List;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.charter.clientrewards.pojo.TransactionSummary;
import com.charter.clientrewards.pojo.RewardsSummary;

@Service
public class RewardsSummaryService {

	Logger logger = LoggerFactory.getLogger(RewardsSummaryService.class);
	
	TransactionSummary transactionSummary = new Gson().fromJson("transactionsummary.json", TransactionSummary.class);
	
	public RewardsSummary calculateRewardsSummary(Integer id) {
		logger.info("Entered the calculate rewards summary method");

		logger.debug("Calculating the rewards");
		int firstMonthRewards = calculateMonthlyRewards(transactionSummary.getMonth1_transactions());
		int secondMonthRewards = calculateMonthlyRewards(transactionSummary.getMonth2_transactions());
		int thirdMonthRewards = calculateMonthlyRewards(transactionSummary.getMonth3_transactions());
		int totalRewards = firstMonthRewards+secondMonthRewards+thirdMonthRewards;

		logger.debug("Set the rewards summary response object");
		RewardsSummary rewardsSummary = new RewardsSummary();
		rewardsSummary.setId(transactionSummary.getId());
		rewardsSummary.setName(transactionSummary.getName());
		rewardsSummary.setFirstMonthRewardSummary(firstMonthRewards);
		rewardsSummary.setSecondMonthRewardSummary(secondMonthRewards);
		rewardsSummary.setThirdMonthRewardSummary(thirdMonthRewards);
		rewardsSummary.setTotalRewardSummary(totalRewards);
		
		return rewardsSummary;
		
	}
	
	public int calculateMonthlyRewards(List<Integer> transactionList) {
		logger.info("Entered the calculate monthly rewards method");
		int rewardAmount = 0;
		for(Integer transactionAmount: transactionList) {
			logger.debug("calculating the points per transaction");
			if(transactionAmount >= 50 && transactionAmount <= 100) {
				rewardAmount += (transactionAmount - 50);
			}else if(transactionAmount > 100) {
				rewardAmount += (2 * (transactionAmount - 100) + 50);
			}
		}
		logger.debug("End calculating the monthly rewards");
		return rewardAmount;
	}

}
