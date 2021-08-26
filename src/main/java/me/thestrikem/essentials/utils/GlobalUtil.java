package me.thestrikem.essentials.utils;

import me.thestrikem.essentials.consts.ConfigConsts;

import java.util.Arrays;
import java.util.function.Consumer;

public class GlobalUtil {
    public static <T> void replaceValues(T message, Consumer<String> function) {
        System.out.println(message);
        String newMessage = String.valueOf(message).replace("%prefix%", ConfigUtil.getConfig(ConfigConsts.MAIN_CONFIG).getString("prefix"));
        Arrays.asList(newMessage.split(";")).stream().forEach(item -> {
            function.accept(item);
        });
    }
}
