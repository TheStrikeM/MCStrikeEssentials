package me.thestrikem.essentials.utils.message;

import me.thestrikem.essentials.consts.ConfigConsts;
import me.thestrikem.essentials.utils.ConfigUtil;
import org.bukkit.entity.Player;

public class MessageLibraryUtil extends MessageUtil {

    public static void sendNoPermission(Player player) {
        send(player, ConfigUtil.getConfig(ConfigConsts.MAIN_CONFIG).getString(ConfigConsts.NO_PERMISSION));
    }

}
