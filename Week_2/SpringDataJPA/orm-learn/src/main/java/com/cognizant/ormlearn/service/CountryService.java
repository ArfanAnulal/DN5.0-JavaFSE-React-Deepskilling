package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        LOGGER.info("Retrieving all country entities from database...");
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        LOGGER.info("Searching country entity for code: {}", countryCode);
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        LOGGER.info("Adding new country entity: {}", country.getName());
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        LOGGER.info("Updating country name for code: {} to {}", code, newName);
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        LOGGER.info("Deleting country entity with code: {}", code);
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameContaining(String name) {
        return countryRepository.findByNameContaining(name);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameContainingOrderByNameAsc(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameStartingWith(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}
