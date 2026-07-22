package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable("number") String number) {
        Map<String, Object> accountMap = new HashMap<>();
        accountMap.put("number", number);
        accountMap.put("type", "savings");
        accountMap.put("balance", 234343);
        return accountMap;
    }
}
