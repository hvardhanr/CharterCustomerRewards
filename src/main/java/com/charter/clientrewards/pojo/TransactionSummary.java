package com.charter.clientrewards.pojo;

import java.util.ArrayList;

public class TransactionSummary {

	int id;
	String name;
	ArrayList<Integer> month1_transactions;
	ArrayList<Integer> month2_transactions;
	ArrayList<Integer> month3_transactions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getMonth1_transactions() {
		return month1_transactions;
	}
	public void setMonth1_transactions(ArrayList<Integer> month1_transactions) {
		this.month1_transactions = month1_transactions;
	}
	public ArrayList<Integer> getMonth2_transactions() {
		return month2_transactions;
	}
	public void setMonth2_transactions(ArrayList<Integer> month2_transactions) {
		this.month2_transactions = month2_transactions;
	}
	public ArrayList<Integer> getMonth3_transactions() {
		return month3_transactions;
	}
	public void setMonth3_transactions(ArrayList<Integer> month3_transactions) {
		this.month3_transactions = month3_transactions;
	}

}
