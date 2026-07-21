package com.finance.forecast;

public class ForecastApp {
    public static void main(String[] args) {
        System.out.println("--- Financial Forecasting Tool ---");
        
        double initialInvestment = 5000.0;
        double annualGrowthRate = 0.08; // 8% growth
        int projectionYears = 5;
        
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Expected Annual Growth: " + (annualGrowthRate * 100) + "%");
        System.out.println("Projection Timeline: " + projectionYears + " years");
        
        double futureVal1 = GrowthPredictor.predictValue(initialInvestment, annualGrowthRate, projectionYears);
        System.out.println("\nCalculated using Standard Recursion: $" + String.format("%.2f", futureVal1));
        
        double futureVal2 = GrowthPredictor.predictValueMemoized(initialInvestment, annualGrowthRate, projectionYears);
        System.out.println("Calculated using Memoized Recursion: $" + String.format("%.2f", futureVal2));
    }
}
