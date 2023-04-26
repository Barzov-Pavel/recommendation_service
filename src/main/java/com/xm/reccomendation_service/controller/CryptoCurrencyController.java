package com.xm.reccomendation_service.controller;

import com.xm.reccomendation_service.dto.CryptoCurrencyStatsDto;
import com.xm.reccomendation_service.service.CryptoCurrency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crypto-currencies")
public class CryptoCurrencyController {

    private final CryptoCurrency cryptoCurrencyService;

    public CryptoCurrencyController(CryptoCurrency cryptoCurrencyService) {
        this.cryptoCurrencyService = cryptoCurrencyService;
    }

    @GetMapping("/{cryptoCurrencyName}/stats")
    public ResponseEntity<CryptoCurrencyStatsDto> getCryptoCurrencyStats(@PathVariable String cryptoCurrencyName,
                                                                         @RequestParam Integer year,
                                                                         @RequestParam Integer month) {

        return new ResponseEntity<>(cryptoCurrencyService
                .getCryptoCurrencyStats(cryptoCurrencyName, year, month), HttpStatus.OK);
    }
}