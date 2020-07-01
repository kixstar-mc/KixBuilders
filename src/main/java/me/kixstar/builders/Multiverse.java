package me.kixstar.builders;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Multiverse {

    public static MultiverseCore getMultiverseCore() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

        if (plugin instanceof MultiverseCore) {
            return (MultiverseCore) plugin;
        }
        return null;
    }

}
