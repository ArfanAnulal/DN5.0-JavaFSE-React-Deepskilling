package com.algorithms.forecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {
    
    // Standard recursion
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    // Optimized recursion with memoization (in case overlapping subproblems are introduced later)
    private static final Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueMemoized(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double result = calculateFutureValueMemoized(presentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, result);
        return result;
    }

    public static void clearMemo() {
        memo.clear();
    }
}
