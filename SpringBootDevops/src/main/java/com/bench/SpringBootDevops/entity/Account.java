package com.bench.SpringBootDevops.entity;

public class Account {

	private int accountId;
	private int accountNo;
	private int customerId;
	private int money;

	public Account(int accountId, int accountNo, int customerId, int money) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.money = money;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Account() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}