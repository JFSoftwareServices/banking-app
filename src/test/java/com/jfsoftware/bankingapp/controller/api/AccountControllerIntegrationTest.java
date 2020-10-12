package com.jfsoftware.bankingapp.controller.api;

import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static java.lang.String.format;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
//https://github.com/eugenp/tutorials/blob/master/spring-boot-modules/spring-boot-testing/src/test/java/com/baeldung/boot/testing/EmployeeControllerIntegrationTest.java
//https://www.youtube.com/watch?v=qPDheVUyH9k
class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private static final String ACCOUNT_NUMBER_1111111 = "1111111";
    private static final BigDecimal BALANCE_10000 = new BigDecimal("10000");

    @Test
    void whenPostAccount_thenCreateAccount() throws Exception {
        Account account = new Account();
        account.setAccountNumber(ACCOUNT_NUMBER_1111111);
        account.setCurrentBalance(BALANCE_10000);
        when(accountService.create(Mockito.any())).thenReturn(account);

        String body = format("{\"accountNumber\":\"%s\",\"currentBalance\":%s}",
                ACCOUNT_NUMBER_1111111, BALANCE_10000);

        mockMvc.perform(post("/api/v1/account/create")
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.displayName())
                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value(ACCOUNT_NUMBER_1111111))
                .andExpect(jsonPath("$.currentBalance").value(BALANCE_10000))
                .andExpect(jsonPath("$.transactions").value(new ArrayList<>()));

        Mockito.verify(accountService, times(1)).create(Mockito.any());
    }

    @Test
    void whenGetAccount_thenFindEmployee() throws Exception {
        Account account = new Account();
        account.setAccountNumber(ACCOUNT_NUMBER_1111111);
        account.setCurrentBalance(BALANCE_10000);
        when(accountService.findByAccountNumber(Mockito.anyString())).thenReturn(account);

        mockMvc.perform(get("/api/v1/account/2222222")
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.displayName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value(ACCOUNT_NUMBER_1111111))
                .andExpect(jsonPath("$.currentBalance").value(BALANCE_10000))
                .andExpect(jsonPath("$.transactions").value(new ArrayList<>()));

        Mockito.verify(accountService, times(1)).findByAccountNumber(Mockito.anyString());
    }
}