package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START SpringLearnApplication main execution");
        displayCountry();
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END SpringLearnApplication main execution");
    }

    public static void displayDate() {
        LOGGER.info("START displayDate");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            try {
                Date date = format.parse("31/12/2018");
                LOGGER.debug("Parsed Date: {}", date);
            } catch (Exception e) {
                LOGGER.error("Error parsing date: ", e);
            }
        }
        LOGGER.info("END displayDate");
    }

    public static void displayCountry() {
        LOGGER.info("START displayCountry");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country.toString());
        }
        LOGGER.info("END displayCountry");
    }

    public static void displayCountries() {
        LOGGER.info("START displayCountries");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            @SuppressWarnings("unchecked")
            List<Country> list = (List<Country>) context.getBean("countryList");
            LOGGER.debug("Country List: {}", list);
        }
        LOGGER.info("END displayCountries");
    }
}
