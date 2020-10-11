package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.dto.request.RequestAccountDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseAccountDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseTransactionDTO;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityDTOMapService {

    @Autowired
    private ModelMapper modelMapper;

    public ResponseAccountDTO convertToDto(Account account) {
        List<ResponseTransactionDTO> transactionDTOs = mapList(account.getTransactions(), ResponseTransactionDTO.class);
        ResponseAccountDTO accountDTO = modelMapper.map(account, ResponseAccountDTO.class);
        accountDTO.setTransactions(transactionDTOs);
        return accountDTO;
    }

    public Account convertToEntity(RequestAccountDTO requestAccountDTO) {
        return modelMapper.map(requestAccountDTO, Account.class);
    }

    public ResponseTransactionDTO convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, ResponseTransactionDTO.class);
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}