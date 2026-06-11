package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end);
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal closePrice);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
