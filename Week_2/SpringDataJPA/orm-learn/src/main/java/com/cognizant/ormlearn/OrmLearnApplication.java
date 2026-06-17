package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static StockService stockService;

    public static void main(String[] args) {
        System.out.println("=== Spring Data JPA & Hibernate Execution Output (June 17) ===");
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);

        System.out.println("\n--- 1. Testing Get All Countries ---");
        testGetAllCountries();

        System.out.println("\n--- 2. Testing Find Country By Code (IN) ---");
        testFindCountryByCode("IN");

        System.out.println("\n--- 3. Testing Find Country By Code (Invalid Code: XX) ---");
        testFindCountryByCode("XX");

        System.out.println("\n--- 4. Testing Add Country (FR, France) ---");
        testAddCountry();

        System.out.println("\n--- 5. Testing Update Country (FR -> French Republic) ---");
        testUpdateCountry();

        System.out.println("\n--- 6. Testing Delete Country (FR) ---");
        testDeleteCountry();

        System.out.println("\n--- 7. Testing Find Countries Containing 'ou' ---");
        testFindCountriesContaining("ou");

        System.out.println("\n--- 8. Testing Find Countries Containing 'ou' Ordered By Name Asc ---");
        testFindCountriesContainingOrderByNameAsc("ou");

        System.out.println("\n--- 9. Testing Find Countries Starting with 'Z' ---");
        testFindCountriesStartingWith("Z");

        System.out.println("\n--- 10. Testing Facebook Sept 2019 Stocks ---");
        testFacebookSept2019();

        System.out.println("\n--- 11. Testing Google close price > 1250 Stocks ---");
        testGoogleAbove1250();

        System.out.println("\n--- 12. Testing Top 3 Highest Volume Stocks ---");
        testTop3HighestVolume();

        System.out.println("\n--- 13. Testing Top 3 Lowest Netflix Stocks ---");
        testTop3LowestNetflix();
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        System.out.println("All Countries size: " + countries.size());
        for (Country c : countries) {
            System.out.println("Code: " + c.getCode() + ", Name: " + c.getName());
        }
    }

    private static void testFindCountryByCode(String code) {
        try {
            Country country = countryService.findCountryByCode(code);
            System.out.println("Found Country: Code: " + country.getCode() + ", Name: " + country.getName());
        } catch (CountryNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void testAddCountry() {
        Country country = new Country("FR", "France");
        countryService.addCountry(country);
        try {
            Country fetched = countryService.findCountryByCode("FR");
            System.out.println("Added successfully: " + fetched);
        } catch (CountryNotFoundException e) {
            System.out.println("Exception adding: " + e.getMessage());
        }
    }

    private static void testUpdateCountry() {
        try {
            countryService.updateCountry("FR", "French Republic");
            Country fetched = countryService.findCountryByCode("FR");
            System.out.println("Updated successfully: " + fetched);
        } catch (CountryNotFoundException e) {
            System.out.println("Exception updating: " + e.getMessage());
        }
    }

    private static void testDeleteCountry() {
        countryService.deleteCountry("FR");
        try {
            countryService.findCountryByCode("FR");
            System.out.println("Failed to delete!");
        } catch (CountryNotFoundException e) {
            System.out.println("Deleted successfully: Country FR not found");
        }
    }

    private static void testFindCountriesContaining(String sub) {
        List<Country> countries = countryService.findByNameContaining(sub);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFindCountriesContainingOrderByNameAsc(String sub) {
        List<Country> countries = countryService.findByNameContainingOrderByNameAsc(sub);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFindCountriesStartingWith(String letter) {
        List<Country> countries = countryService.findByNameStartingWith(letter);
        for (Country c : countries) {
            System.out.println(c.getCode() + " | " + c.getName());
        }
    }

    private static void testFacebookSept2019() {
        List<Stock> stocks = stockService.getFacebookSept2019();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testGoogleAbove1250() {
        List<Stock> stocks = stockService.getGoogleAbove1250();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testTop3HighestVolume() {
        List<Stock> stocks = stockService.getTop3HighestVolume();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }

    private static void testTop3LowestNetflix() {
        List<Stock> stocks = stockService.getTop3LowestNetflix();
        System.out.println("+---------+------------+---------+----------+-----------+");
        System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
        System.out.println("+---------+------------+---------+----------+-----------+");
        for (Stock s : stocks) {
            System.out.printf("| %-7s | %-10s | %7.2f | %8.2f | %9d |\n",
                    s.getCode(), s.getDate(), s.getOpen(), s.getClose(), s.getVolume());
        }
        System.out.println("+---------+------------+---------+----------+-----------+");
    }
}
