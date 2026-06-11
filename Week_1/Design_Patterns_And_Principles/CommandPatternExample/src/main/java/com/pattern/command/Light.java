package com.pattern.command;

public class Light {
    private boolean on = false;

    public void turnOn() {
        on = true;
        System.out.println("The light is ON");
    }

    public void turnOff() {
        on = false;
        System.out.println("The light is OFF");
    }

    public boolean isOn() {
        return on;
    }
}
