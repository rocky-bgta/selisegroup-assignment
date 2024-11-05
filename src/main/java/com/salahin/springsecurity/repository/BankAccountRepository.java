package com.salahin.springsecurity.repository;

import com.salahin.springsecurity.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    List<BankAccount> findByAccountNumber(String accountNumber);
}
