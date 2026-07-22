package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable("number") String number) {
        Map<String, Object> loanMap = new HashMap<>();
        loanMap.put("number", number);
        loanMap.put("type", "car");
        loanMap.put("loan", 400000);
        loanMap.put("emi", 3258);
        loanMap.put("tenure", 18);
        return loanMap;
    }
}
