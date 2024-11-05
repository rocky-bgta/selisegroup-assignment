package com.salahin.springsecurity;

import com.salahin.springsecurity.constants.AccountStatus;
import com.salahin.springsecurity.controllers.AccountController;
import com.salahin.springsecurity.entity.BankAccountEntity;
import com.salahin.springsecurity.service.BankAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BankAccountService bankAccountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    public void testGetAccountByAccountNumber_Success() throws Exception {
        // Arrange
        String accountNumber = "ACC1001";
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setAccountId(1);
        bankAccountEntity.setAccountNumber(accountNumber);
        bankAccountEntity.setBalance(BigDecimal.valueOf(1500.00));
        bankAccountEntity.setStatus(AccountStatus.ACTIVE);

        List<BankAccountEntity> bankAccountEntityList = Collections.singletonList(bankAccountEntity);

        when(bankAccountService.retrieveBankAccountByAccountNumber(accountNumber)).thenReturn(bankAccountEntityList);

        // Act and Assert
        mockMvc.perform(get("/api/accounts/{accountNumber}", accountNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accountId", is(1)))
                .andExpect(jsonPath("$[0].accountNumber", is(accountNumber)))
                .andExpect(jsonPath("$[0].balance", is(1500.00)))
                .andExpect(jsonPath("$[0].status", is("ACTIVE")));
    }

    @Test
    public void testGetAccountByAccountNumber_NotFound() throws Exception {
        // Arrange
        String accountNumber = "ACC9999";
        when(bankAccountService.retrieveBankAccountByAccountNumber(accountNumber)).thenReturn(Collections.emptyList());

        // Act and Assert
        mockMvc.perform(get("/api/accounts/{accountNumber}", accountNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGetAccountByAccountNumber_InvalidRequest() throws Exception {
        // Act and Assert
        mockMvc.perform(get("/api/accounts/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
