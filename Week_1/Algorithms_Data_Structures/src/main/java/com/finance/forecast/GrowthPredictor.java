package com.finance.forecast;

import java.util.HashMap;
import java.util.Map;

public class GrowthPredictor {
    
    // simple recursion to predict future value based on past growth
    public static double predictValue(double currentVal, double rate, int years) {
        // base case: no more years to calculate
        if (years == 0) {
            return currentVal;
        }
        return predictValue(currentVal * (1 + rate), rate, years - 1);
    }

    // memoized version to avoid redundant calculations if we expand this later
    private static Map<Integer, Double> cache = new HashMap<>();

    public static double predictValueMemoized(double currentVal, double rate, int years) {
        if (years == 0) {
            return currentVal;
        }
        
        if (cache.containsKey(years)) {
            return cache.get(years);
        }
        
        double calculatedVal = predictValueMemoized(currentVal * (1 + rate), rate, years - 1);
        cache.put(years, calculatedVal);
        return calculatedVal;
    }

    public static void resetCache() {
        cache.clear();
    }
}
