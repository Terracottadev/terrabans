package org.terradev.terrabans.evt;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.terradev.terrabans.Terrabans;

public class TerrabansJoinListener implements Listener {

    private final Terrabans plugin;
    
    public TerrabansJoinListener(final Terrabans pluginInstance) {
        plugin = pluginInstance;
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoinEvent(AsyncPlayerPreLoginEvent evt) {
        // TODO ban reason
        if (plugin.isBanned(evt.getAddress()) || plugin.isBanned(evt.getName())) {
            evt.disallow(Result.KICK_BANNED, plugin.getBanMessage());
        }
    }
}
