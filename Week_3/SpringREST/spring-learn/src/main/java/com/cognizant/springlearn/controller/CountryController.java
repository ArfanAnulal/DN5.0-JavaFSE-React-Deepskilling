package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country indiaBean = context.getBean("country", Country.class);
            LOGGER.debug("Fetched India Country Bean: {}", indiaBean);
            LOGGER.info("END getCountryIndia");
            return indiaBean;
        }
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        List<Country> countryList = countryService.getAllCountries();
        LOGGER.debug("Total Countries Loaded: {}", countryList.size());
        LOGGER.info("END getAllCountries");
        return countryList;
    }

    @GetMapping({"/countries/{code}", "/country/{code}"})
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry with code: {}", code);
        Country targetCountry = countryService.getCountry(code);
        LOGGER.debug("Found Country: {}", targetCountry);
        LOGGER.info("END getCountry");
        return targetCountry;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country countryPayload) {
        LOGGER.info("START addCountry");
        LOGGER.debug("Received Country Payload: {}", countryPayload);
        LOGGER.info("END addCountry");
        return countryPayload;
    }
}
