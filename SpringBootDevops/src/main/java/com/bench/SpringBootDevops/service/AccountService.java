package com.bench.SpringBootDevops.service;

import java.util.List;

import com.bench.SpringBootDevops.entity.Account;

public interface AccountService {

	public List<Account> getAllAccounts();

	public Account getAccountOfCustomer(int accountId);

	public String addMoney(int accountId, int money, int customerId);

	public String withdrawMoney(int accountId, int money, int customerId);

	public void deleteAccountOfCustomer(int accountId);

}