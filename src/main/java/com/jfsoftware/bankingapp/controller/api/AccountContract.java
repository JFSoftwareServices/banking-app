package com.jfsoftware.bankingapp.controller.api;

import com.jfsoftware.bankingapp.dto.request.RequestAccountDTO;
import com.jfsoftware.bankingapp.dto.request.RequestTransferBalanceDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseAccountDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseStatementDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseTransactionDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.List;

@RequestMapping(value = "/api/v1/account",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public interface AccountContract {

    //If we need headers then use RequestEntity rather than RequestBody
    //https://goodwinwei.wordpress.com/2017/01/06/springresquestbody-responsebody-vs-httpentityresponseentity/
    @PostMapping("/create")
    ResponseEntity<ResponseAccountDTO> create(@RequestBody() RequestAccountDTO requestAccountDTO);

    @GetMapping("/all")
    ResponseEntity<List<ResponseAccountDTO>> findAll();

    @PostMapping("/sendmoney")
    ResponseEntity<ResponseTransactionDTO> sendMoney(@RequestBody() RequestTransferBalanceDTO transferBalanceRequest);

    @GetMapping("/statement/{accountNumber}")
    ResponseEntity<ResponseStatementDTO> getStatement(@PathVariable()
                                                      @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
                                                              String accountNumber);

    @GetMapping("/{accountNumber}")
    ResponseEntity<ResponseAccountDTO> findByAccountNumber(@PathVariable()
                                                           @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
                                                                   String accountNumber) throws ParseException;
}