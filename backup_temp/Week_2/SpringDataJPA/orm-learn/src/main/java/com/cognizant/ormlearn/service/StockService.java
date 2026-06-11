package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<Stock> getFacebookSept2019() {
        return stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
    }

    @Transactional(readOnly = true)
    public List<Stock> getGoogleAbove1250() {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250.00"));
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3HighestVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3LowestNetflix() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
