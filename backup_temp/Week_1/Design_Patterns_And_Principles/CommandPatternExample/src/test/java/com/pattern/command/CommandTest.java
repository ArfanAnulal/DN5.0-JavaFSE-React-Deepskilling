package com.pattern.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {
    @Test
    public void testCommandExecution() {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Turn Light On
        remote.setCommand(lightOn);
        remote.pressButton();
        assertTrue(livingRoomLight.isOn());

        // Turn Light Off
        remote.setCommand(lightOff);
        remote.pressButton();
        assertFalse(livingRoomLight.isOn());
    }
}
