package com.charter.clientrewards.service;

import com.charter.clientrewards.pojo.RewardsSummary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.charter.clientrewards.service.RewardsSummaryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RewardsSummaryServiceTest {

    @Autowired
    private RewardsSummaryService rewardsSummaryService;

    private RewardsSummary rewardsSummary;

    List<Integer> transactionList;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCalculateRewardsSummary(){
        assertSame(rewardsSummaryService.calculateRewardsSummary(1), rewardsSummary);
    }

    @Test
    public void testCalculateMonthlyRewards_where_allTransactionsAboveHundred(){
        transactionList = new ArrayList<Integer>(Arrays.asList(120, 160, 100));
        assertEquals(310, rewardsSummaryService.calculateMonthlyRewards(transactionList));
    }

    @Test
    public void testCalculateMonthlyRewards_where_allTransactionsBetweenFiftyAndHundred(){
        transactionList = new ArrayList<Integer>(Arrays.asList(60, 80, 60));
        assertEquals(50, rewardsSummaryService.calculateMonthlyRewards(transactionList));
    }

    @Test
    public void testCalculateMonthlyRewards_where_allTransactionsBelowFifty(){
        transactionList = new ArrayList<Integer>(Arrays.asList(20, 10, 30));
        assertEquals(0, rewardsSummaryService.calculateMonthlyRewards(transactionList));
    }

    @Test
    public void testCalculateMonthlyRewards_where_noTransactions(){
        transactionList = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        assertEquals(0, rewardsSummaryService.calculateMonthlyRewards(transactionList));
    }
}
