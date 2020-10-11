package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.dto.response.ResponseAccountDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseTransactionDTO;
import com.jfsoftware.bankingapp.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperService {

    @Autowired
    private ModelMapper modelMapper;

    public ResponseAccountDTO convertAccountToAccountDto(Account account) {
        List<ResponseTransactionDTO> transactionDTOs = mapList(account.getTransactions(), ResponseTransactionDTO.class);
        ResponseAccountDTO accountDTO = modelMap(account, ResponseAccountDTO.class);
        accountDTO.setTransactions(transactionDTOs);
        return accountDTO;
    }

    public <T, S> S modelMap(T source, Class<S> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}