package com.pattern.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {
    @Test
    public void testBasicComputer() {
        Computer computer = new Computer.Builder("Intel i5", "8GB").build();
        assertEquals("Intel i5", computer.getCPU());
        assertEquals("8GB", computer.getRAM());
        assertNull(computer.getStorage());
        assertFalse(computer.hasWifi());
    }

    @Test
    public void testGamingComputer() {
        Computer computer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("2TB NVMe")
                .setGPU("NVIDIA RTX 4080")
                .setOS("Windows 11")
                .setWifi(true)
                .build();
        assertEquals("AMD Ryzen 9", computer.getCPU());
        assertEquals("32GB", computer.getRAM());
        assertEquals("2TB NVMe", computer.getStorage());
        assertEquals("NVIDIA RTX 4080", computer.getGPU());
        assertEquals("Windows 11", computer.getOS());
        assertTrue(computer.hasWifi());
    }
}
