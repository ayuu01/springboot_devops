package com.bench.SpringBootDevops.controller;

import com.bench.SpringBootDevops.entity.Account;
import com.bench.SpringBootDevops.service.AccountServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;

	@GetMapping
	public List<Account> getAllCustomers() {
		return accountService.getAllAccounts();
	}

	@RequestMapping("{accountId}")
	public Account getAccount(@PathVariable("accountId") int accountId) {

		Account account = accountService.getAccountOfCustomer(accountId);
		return account;
	}

	@PutMapping("add/money")
	public String addMoney(@RequestParam(name = "accountId") int accountId, @RequestParam(name = "money") int money,
			@RequestParam(name = "customerId") int customerId) {
		return accountService.addMoney(accountId, money, customerId);
	}

	@PutMapping("withdraw/money")
	public String withdrawMoney(@RequestParam(name = "accountId") int accountId,
			@RequestParam(name = "money") int money, @RequestParam(name = "customerId") int customerId) {
		return accountService.withdrawMoney(accountId, money, customerId);
	}

	@DeleteMapping("{accountId}")
	public void deleteAccount(@PathVariable int accountId) {
		accountService.deleteAccountOfCustomer(accountId);
	}

}