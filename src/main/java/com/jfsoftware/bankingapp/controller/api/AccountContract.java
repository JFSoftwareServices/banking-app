package com.jfsoftware.bankingapp.controller.api;

import com.jfsoftware.bankingapp.controller.request.TransferBalanceRequest;
import com.jfsoftware.bankingapp.dto.AccountStatement;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

@RequestMapping(value = "/api/v1/account",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public interface AccountContract {

    //If we need headers then use RequestEntity rather than RequestBody
    //https://goodwinwei.wordpress.com/2017/01/06/springresquestbody-responsebody-vs-httpentityresponseentity/
    @PostMapping("/create")
    ResponseEntity<Account> create(@RequestBody() Account account);

    @GetMapping("/all")
    ResponseEntity<List<Account>> findAll();

    @PostMapping("/sendmoney")
    ResponseEntity<Transaction> sendMoney(@RequestBody() TransferBalanceRequest transferBalanceRequest);

    @GetMapping("/statement/{accountNumber}")
    ResponseEntity<AccountStatement> getStatement(@PathVariable()
                                                  @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
                                                          String accountNumber);

    @GetMapping("/{accountNumber}")
    ResponseEntity<Account> findByAccountNumber(@PathVariable()
                                                @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
                                                        String accountNumber);
}