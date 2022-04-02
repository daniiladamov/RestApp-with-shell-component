package com.adamov.currencies.shellComponens;

import com.adamov.currencies.entites.Currency;
import com.adamov.currencies.repositories.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class CurrencyShell {
    CurrencyRepository currencyRepository;

    @ShellMethod("update the currency by id")
    public String update(Long id,String updateValue) {
        Currency currency=currencyRepository.findById(id);
        if (currency==null)
            return String.format("Currency with id=%d was not found in the database",id);
        if (!updateValue.matches("0[.]\\d{1,4}") && !updateValue.matches("[1-9]\\d{0,3}[.]\\d{1,4}"))
            return String.format("The value %s of the updated currency does not match the required format " +
                    "(0.XXXX or XXXX.XXXX)",updateValue);
        currencyRepository.updateCurrency(id,updateValue);
        return String.format("The currency with id=%d was updated; new value=%s",id,updateValue);
    }
}
