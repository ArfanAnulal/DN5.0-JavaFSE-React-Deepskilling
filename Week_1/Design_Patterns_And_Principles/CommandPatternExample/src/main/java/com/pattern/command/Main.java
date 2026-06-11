package com.pattern.command;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern Execution Output ===");
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        
        RemoteControl remote = new RemoteControl();
        
        System.out.println("Pressing ON button:");
        remote.setCommand(lightOn);
        remote.pressButton();
        
        System.out.println("\nPressing OFF button:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
