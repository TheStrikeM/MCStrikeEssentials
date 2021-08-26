package me.thestrikem.essentials.interfaces;

public abstract class AbstractCommand {
    public abstract String getDesc();
    public abstract String[] getAliases();
    public abstract String getPermission();
    public abstract String getCommand();
}
