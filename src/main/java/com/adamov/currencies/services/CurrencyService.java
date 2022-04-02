package com.adamov.currencies.services;

import com.adamov.currencies.entites.Currency;
import com.adamov.currencies.repositories.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;


    public List<Currency> getList() {
       return currencyRepository.findAll();
    }

    public Currency getCurrency(Long id) {
       return currencyRepository.findById(id);
    }
}
