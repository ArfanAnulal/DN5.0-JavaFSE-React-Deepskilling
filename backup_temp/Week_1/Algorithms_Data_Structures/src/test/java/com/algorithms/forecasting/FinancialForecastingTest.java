package com.algorithms.forecasting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinancialForecastingTest {
    @Test
    public void testFinancialForecasting() {
        double pv = 1000.0;
        double rate = 0.05; // 5% growth
        int periods = 10;

        double expected = pv * Math.pow(1 + rate, periods);
        
        double fvStandard = FinancialForecasting.calculateFutureValue(pv, rate, periods);
        double fvMemoized = FinancialForecasting.calculateFutureValueMemoized(pv, rate, periods);

        assertEquals(expected, fvStandard, 0.0001);
        assertEquals(expected, fvMemoized, 0.0001);
    }
}
