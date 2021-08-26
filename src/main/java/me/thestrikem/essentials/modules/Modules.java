package me.thestrikem.essentials.modules;

public class Modules {
    public EventRegister getEventRegister() {
        return new EventRegister();
    }

    public CommandRegister getCommandRegister() {
        return new CommandRegister();
    }
}
