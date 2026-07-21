package com.finance.forecast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrowthPredictorTest {
    @Test
    public void testForecastingAccuracy() {
        double currentVal = 1000.0;
        double rate = 0.05; // 5% growth
        int years = 10;

        double expectedVal = currentVal * Math.pow(1 + rate, years);
        
        double standardResult = GrowthPredictor.predictValue(currentVal, rate, years);
        double memoizedResult = GrowthPredictor.predictValueMemoized(currentVal, rate, years);

        assertEquals(expectedVal, standardResult, 0.0001);
        assertEquals(expectedVal, memoizedResult, 0.0001);
    }
}
