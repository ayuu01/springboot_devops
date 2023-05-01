package com.bench.SpringBootDevops.entity;

public class Customer {
	

	private int customerId;
	private String name;
	private Account account;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String name) {
		this.customerId = customerId;
		this.name=name;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}