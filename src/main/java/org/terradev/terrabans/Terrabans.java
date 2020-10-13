package org.terradev.terrabans;

import java.net.InetAddress;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.terradev.terrabans.evt.TerrabansJoinListener;

public final class Terrabans extends JavaPlugin {
    
    private boolean doIPBans = false;
    
    @Override
    public void onEnable() {
        doIPBans = getConfig().getBoolean("banIPs");
        Bukkit.getPluginManager().registerEvents(new TerrabansJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    /**
     * This method must be Thread-safe!
     * @return Whether the given InetAdress is banned
     */
    public boolean isBanned(InetAddress playerAddress) {
        return doIPBans;
    }
    
    /**
     * This method must be Thread-safe!
     * @return Whether the given playername is banned
     */
    public boolean isBanned(String playerName) {
        return false;
    }
    
    /**
     * This method must be Thread-safe!
     * @return The message shown to the banned user
     */
    public String getBanMessage() {
        return getConfig().getString("banMessage");
    }
}
