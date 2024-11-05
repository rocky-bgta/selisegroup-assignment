package com.salahin.springsecurity.service;

import com.salahin.springsecurity.entity.BankAccountEntity;

import java.util.List;

public interface BankAccountService {
    List<BankAccountEntity> retrieveBankAccountByAccountNumber(String accountNumber);
}
