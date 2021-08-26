package me.thestrikem.essentials.utils;

import me.thestrikem.essentials.consts.ConfigConsts;
import me.thestrikem.essentials.utils.message.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.function.Consumer;


public class CommandUtil {
    public static void checkConsole(CommandSender sender, Consumer<Player> function) {
        if (sender instanceof Player) {
            function.accept((Player) sender);
        } else LoggerUtil.sendError("&cConsole don't must do this.");
    }

    public static void checkConsoleWithPerms(CommandSender sender,
                                             String permissionName,
                                             Consumer<Player> function) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(permissionName)) {
                function.accept(player);
            } else MessageUtil.send(player, ConfigUtil.getConfig(ConfigConsts.MAIN_CONFIG).getString("no-permission"));
        } else LoggerUtil.sendError("&cConsole don't must do this.");
    }
}
