package me.thestrikem.essentials.modules.joiner;

import me.thestrikem.essentials.consts.PermissionsConst;
import me.thestrikem.essentials.interfaces.AbstractCommand;
import me.thestrikem.essentials.utils.CommandUtil;
import me.thestrikem.essentials.utils.message.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

public class JoinerCommand extends AbstractCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        CommandUtil.checkConsoleWithPerms(sender, PermissionsConst.JOINER_USE_COMMAND, (player) -> {
            HashMap<Integer, String> messagesWithPerms = JoinerUtil.getMessagesWithPerms();

            switch (args[0]) {
                case "all": {
                    StringBuilder finalResult = new StringBuilder();
                    int i = 0;
                    messagesWithPerms.forEach((key, value) -> {
                        finalResult.append(String.format("%s - %s;", key, value.split(";")[1]));
                    });
                    MessageUtil.send(player, finalResult.toString());
                    break;

                }
                case "set": {
                    int index = Integer.parseInt(args[1]);
                    if (player.hasPermission(messagesWithPerms.get(index).split(";")[0])) {
                        MessageUtil.send(player, "&a&lSuccess");
                    }
                    break;
                }
                case "get": {
                    int index = Integer.parseInt(args[1]);
                    MessageUtil.send(player, messagesWithPerms.get(index).split(";")[1]);
                    break;
                }
            }
        });
        return true;
    }

    @Override
    public String getDesc() {
        return "Joiner command";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"joiner", "join"};
    }

    @Override
    public String getPermission() {
        return PermissionsConst.JOINER_USE_COMMAND;
    }

    @Override
    public String getCommand() {
        return "joiner";
    }
}
