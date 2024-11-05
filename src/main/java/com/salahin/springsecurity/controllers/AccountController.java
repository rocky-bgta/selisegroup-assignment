package com.salahin.springsecurity.controllers;

import com.salahin.springsecurity.entity.BankAccountEntity;
import com.salahin.springsecurity.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccountByAccountNumber(@PathVariable String accountNumber) {
        List<BankAccountEntity> bankAccountEntityList;
        bankAccountEntityList = bankAccountService.retrieveBankAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(bankAccountEntityList, HttpStatus.OK);
    }
}