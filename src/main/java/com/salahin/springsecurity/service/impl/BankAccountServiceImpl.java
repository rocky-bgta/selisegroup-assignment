package com.salahin.springsecurity.service.impl;

import com.salahin.springsecurity.entity.BankAccountEntity;
import com.salahin.springsecurity.repository.BankAccountRepository;
import com.salahin.springsecurity.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountEntity> retrieveBankAccountByAccountNumber(String accountNumber) {
        if(!ObjectUtils.isEmpty(accountNumber)){
            return bankAccountRepository.findByAccountNumber(accountNumber);
        }else {
            return null;
        }
    }
}
