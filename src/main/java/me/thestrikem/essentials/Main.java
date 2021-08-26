package me.thestrikem.essentials;

import me.thestrikem.essentials.modules.Modules;
import me.thestrikem.essentials.modules.joiner.JoinerCommand;
import me.thestrikem.essentials.utils.ConfigUtil;
import me.thestrikem.essentials.utils.LoggerUtil;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main main;

    @Override
    public void onEnable() {
        this.main = this;
        new ConfigUtil(new String[]{"main", "events", "joiner"}).init();

        Modules modules = new Modules();
        modules.getEventRegister().registerAllEvents();
        modules.getCommandRegister().registerAllCommands();
        LoggerUtil.sendSuccess(
                "&f&aПлагин StrikeEssentials успешно запущен;&f&aАвтор плагина - github.com/thestrikem"
        );
    }

    public static Main getInstance() {
        return main;
    }

    @Override
    public void onDisable() {
        LoggerUtil.sendSuccess(
                "&f&aПлагин StrikeEssentials успешно выключен;Автор плагина - github.com/thestrikem"
        );
    }
}
