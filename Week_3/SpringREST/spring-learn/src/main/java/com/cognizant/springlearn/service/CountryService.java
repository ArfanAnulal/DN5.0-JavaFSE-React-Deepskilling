package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    private List<Country> countries;

    public CountryService() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            @SuppressWarnings("unchecked")
            List<Country> catalog = (List<Country>) context.getBean("countryList");
            this.countries = catalog;
        }
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }
}
