package com.algorithms.forecasting;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Output (Exercise 7) ===");
        double pv = 1000.0;
        double growth = 0.05;
        int periods = 10;
        
        System.out.println("Present Value: $" + pv);
        System.out.println("Growth Rate: " + (growth * 100) + "%");
        System.out.println("Periods: " + periods);
        
        double fv1 = FinancialForecasting.calculateFutureValue(pv, growth, periods);
        System.out.println("Recursive Forecasted Value: $" + String.format("%.2f", fv1));
        
        double fv2 = FinancialForecasting.calculateFutureValueMemoized(pv, growth, periods);
        System.out.println("Memoized Forecasted Value: $" + String.format("%.2f", fv2));
    }
}
