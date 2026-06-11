package com.pattern.builder;

public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String GPU;
    private final String OS;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
        this.hasWifi = builder.hasWifi;
    }

    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGPU() { return GPU; }
    public String getOS() { return OS; }
    public boolean hasWifi() { return hasWifi; }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String OS;
        private boolean hasWifi;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        public Builder setWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
