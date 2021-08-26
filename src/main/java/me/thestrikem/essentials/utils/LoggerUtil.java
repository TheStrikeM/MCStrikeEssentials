package me.thestrikem.essentials.utils;

import me.thestrikem.essentials.Main;
import me.thestrikem.essentials.consts.LoggerConsts;
import me.thestrikem.essentials.utils.message.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;

public class LoggerUtil {
    private static void sendMessage(String loggerType, String message) {
        PluginDescriptionFile desc = Main.getInstance().getDescription();
        message = MessageUtil.translateColorCodes(message);
        Bukkit.getConsoleSender().sendMessage(String.format("[%s/%s] %s", desc.getName()+":"+desc.getVersion(), loggerType, message));
    }

    public static <T> void sendSuccess(T message) {
        GlobalUtil.replaceValues(message, item -> {
            LoggerUtil.sendMessage(LoggerConsts.LOGGER_SUCCESS, item);
        });
    }

    public static <T> void sendInfo(T message) {
        GlobalUtil.replaceValues(message, item -> {
            LoggerUtil.sendMessage(LoggerConsts.LOGGER_INFO, item);
        });
    }

    public static <T> void sendWarn(T message) {
        GlobalUtil.replaceValues(message, item -> {
            LoggerUtil.sendMessage(LoggerConsts.LOGGER_WARN, item);
        });
    }

    public static <T> void sendError(T message) {
        GlobalUtil.replaceValues(message, item -> {
            LoggerUtil.sendMessage(LoggerConsts.LOGGER_ERROR, item);
        });
    }
}
