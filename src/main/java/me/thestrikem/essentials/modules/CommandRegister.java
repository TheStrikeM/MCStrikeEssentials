package me.thestrikem.essentials.modules;

import me.thestrikem.essentials.Main;
import me.thestrikem.essentials.interfaces.AbstractCommand;
import me.thestrikem.essentials.modules.joiner.JoinerCommand;
import org.bukkit.command.CommandExecutor;

import java.util.Arrays;
import java.util.List;

public class CommandRegister {
    private List<AbstractCommand> commands = Arrays.asList(new AbstractCommand[]{
            new JoinerCommand(),
    });

    public void registerAllCommands() {
        Main main = Main.getInstance();
        commands.stream().forEach(command -> {
            main.getCommand("joiner").setExecutor((CommandExecutor) command);
        });
    }
}
