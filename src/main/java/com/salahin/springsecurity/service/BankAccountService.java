package com.salahin.springsecurity.service;

import com.salahin.springsecurity.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> retrieveBankAccountByAccountNumber(String accountNumber);
}
