package com.pattern.builder;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Execution Output ===");
        
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
            .setStorage("2TB NVMe SSD")
            .setGPU("NVIDIA RTX 4090")
            .setOS("Windows 11")
            .setWifi(true)
            .build();
            
        System.out.println("Gaming PC Built:");
        System.out.println("CPU: " + gamingPC.getCPU());
        System.out.println("RAM: " + gamingPC.getRAM());
        System.out.println("Storage: " + gamingPC.getStorage());
        System.out.println("GPU: " + gamingPC.getGPU());
        System.out.println("OS: " + gamingPC.getOS());
        System.out.println("Wifi Enabled: " + gamingPC.hasWifi());
        
        Computer officePC = new Computer.Builder("Intel i3", "8GB")
            .setStorage("500GB HDD")
            .setOS("Windows 10")
            .setWifi(true)
            .build();
            
        System.out.println("\nOffice PC Built:");
        System.out.println("CPU: " + officePC.getCPU());
        System.out.println("RAM: " + officePC.getRAM());
        System.out.println("Storage: " + officePC.getStorage());
        System.out.println("GPU: " + officePC.getGPU());
        System.out.println("OS: " + officePC.getOS());
        System.out.println("Wifi Enabled: " + officePC.hasWifi());
    }
}
