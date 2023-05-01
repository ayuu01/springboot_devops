package com.bench.SpringBootDevops.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bench.SpringBootDevops.entity.Account;
import com.bench.SpringBootDevops.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	static List<Account> list = new ArrayList<>();
	static {
		list.add(new Account(1, 123, 1, 0));
		list.add(new Account(2, 456, 2, 0));
		list.add(new Account(3, 789, 3, 0));
	}

	@Override
	public List<Account> getAllAccounts() {
		return list;
	}

	@Override
	public Account getAccountOfCustomer(int accountId) {

		// return list.stream().filter(account -> account.getAccountId() ==
		// (accountId)).findAny().orElse(null);
		int accountIdInList = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountId() == (accountId)) {
				accountIdInList = list.get(i).getAccountId();
				return list.get(i);
			}
		}

		if (accountIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId is not valid..");
		}

		return null;
	}

	@Override
	public String addMoney(int accountId, int money, int customerId) {
		int idx = 0;
		int accountIdInList = 0;
		int accountNo = 0;
		int customerIdInList = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountId() == accountId && list.get(i).getCustomerId() == customerId) {
				accountIdInList = list.get(i).getAccountId();
				accountNo = list.get(i).getAccountNo();
				customerIdInList = list.get(i).getCustomerId();
				idx = i;
				break;
			}

			if (list.get(i).getAccountId() == accountId) {
				accountIdInList = list.get(i).getAccountId();
			}

			if (list.get(i).getCustomerId() == customerId) {
				customerIdInList = list.get(i).getCustomerId();
			}
		}

		if (accountIdInList == 0 && customerIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId and CustomerDetail is not valid.");
		}

		if (accountIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId does is not valid..");
		}

		if (customerIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Customer Detail is not valid.");
		}

		Account account1 = new Account();
		account1.setAccountId(accountIdInList);
		account1.setAccountNo(accountNo);
		account1.setCustomerId(customerId);
		account1.setMoney(money);
		list.set(idx, account1);
		return "money added";
	}

	@Override
	public String withdrawMoney(int accountId, int money, int customerId) {
		int idx = 0;
		int accountIdInList = 0;
		int accountNo = 0;
		int customerIdInList = 0;
		int totalMoney = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountId() == accountId && list.get(i).getCustomerId() == customerId) {
				accountIdInList = list.get(i).getAccountId();
				accountNo = list.get(i).getAccountNo();
				customerIdInList = list.get(i).getCustomerId();
				totalMoney = list.get(i).getMoney();
				idx = i;
				break;
			}

			if (list.get(i).getAccountId() == accountId) {
				accountIdInList = list.get(i).getAccountId();
			}

			if (list.get(i).getCustomerId() == customerId) {
				customerIdInList = list.get(i).getCustomerId();
			}
		}

		if (accountIdInList == 0 && customerIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId and CustomerDetail is not valid.");
		}

		if (accountIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId is not valid.");
		}

		if (customerIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Customer Detail is not valid.");
		}

		Account account1 = new Account();
		account1.setAccountId(accountIdInList);
		account1.setAccountNo(accountNo);
		account1.setCustomerId(customerId);
		account1.setMoney(totalMoney - money);
		list.set(idx, account1);
		return "money wihdraw";
	}

	@Override
	public void deleteAccountOfCustomer(int accountId) {

		int accountIdInList = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountId() == (accountId)) {
				accountIdInList = list.get(i).getAccountId();
			}
		}

		if (accountIdInList == 0) {
			throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "AccountId does not found.");
		}

		list.removeIf(x -> x.getAccountId() == accountId);
		// return null;
	}

}