package me.thestrikem.essentials.modules;

import me.thestrikem.essentials.Main;
import me.thestrikem.essentials.modules.events.HideStreamEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.util.Arrays;

public class EventRegister {
    private Listener[] events = new Listener[]{
            new HideStreamEvent(),
    };

    public void registerAllEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        Arrays.stream(events).forEach(event -> {
            pluginManager.registerEvents(event, Main.getInstance());
        });
    }
}
