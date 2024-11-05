package com.salahin.springsecurity.repository;

import com.salahin.springsecurity.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Integer> {
    List<BankAccountEntity> findByAccountNumber(String accountNumber);
    List<BankAccountEntity> findAll();
}
