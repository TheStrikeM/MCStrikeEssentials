package me.thestrikem.essentials.modules.events;

import me.thestrikem.essentials.consts.ConfigConsts;
import me.thestrikem.essentials.utils.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class HideStreamEvent implements Listener {
    FileConfiguration config = ConfigUtil.getConfig(ConfigConsts.EVENTS_CONFIG);
    boolean disableAll = this.config.getBoolean(ConfigConsts.HIDESTREAM_DISABLE_ALL);

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (disableAll || this.config.getBoolean(ConfigConsts.HIDESTREAM_DISABLE_QUIT_EVENT)) {
            e.setQuitMessage(null);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (disableAll || this.config.getBoolean(ConfigConsts.HIDESTREAM_DISABLE_JOIN_EVENT)) {
            e.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (disableAll || this.config.getBoolean(ConfigConsts.HIDESTREAM_DISABLE_DEATH_EVENT)) {
            e.setDeathMessage(null);
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        if (disableAll || this.config.getBoolean(ConfigConsts.HIDESTREAM_DISABLE_KICK_EVENT)) {
            e.setLeaveMessage(null);
        }
    }
}
