package com.adamov.currencies.controllers;

import com.adamov.currencies.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrencyController {
    private final Environment environment;
    private final CurrencyService currencyService;



    @GetMapping("/currencies")
    public ResponseEntity getList(@RequestHeader(name="authorization") String token){
        String[] auth=token.split(" ");
        if (auth[0].toLowerCase().equals("bearer") && auth[1].toLowerCase().equals(environment.getProperty("token")))
        return ResponseEntity.ok(currencyService.getList());
        else return ResponseEntity.badRequest().body("you need the right bearer token for this request");
    }

    @GetMapping("/currency/{id}")
    public ResponseEntity getCurrency(@PathVariable Long id, @RequestHeader(name="authorization") String token){
        String[] auth=token.split(" ");
        if (auth[0].toLowerCase().equals("bearer") && auth[1].toLowerCase().equals(environment.getProperty("token")))
        return ResponseEntity.ok().body(currencyService.getCurrency(id));
        else return ResponseEntity.badRequest().body("you need the right bearer token for this request");
    }



}
