package me.thestrikem.essentials.modules.joiner;

import me.thestrikem.essentials.consts.ConfigConsts;
import me.thestrikem.essentials.utils.ConfigUtil;

import java.util.HashMap;
import java.util.List;

public class JoinerUtil {
    private HashMap<Integer, String> messagesWithPerms = new HashMap<>();

    private void getFromConfig() {
        List<String> messages = ConfigUtil.getConfig(ConfigConsts.JOINER_CONFIG).getStringList(ConfigConsts.JOINER_MESSAGES);
        final int[] i = {0};
        messages.stream().forEach(message -> {
            String[] spltMessage = message.split(";");
            messagesWithPerms.put(i[0], String.format("%s;%s", spltMessage[0], spltMessage[1]));
            i[0]++;
        });
    }

    public static HashMap<Integer, String> getMessagesWithPerms() {
        JoinerUtil joinerUtil = new JoinerUtil();
        joinerUtil.getFromConfig();
        return joinerUtil.messagesWithPerms;
    }
}
