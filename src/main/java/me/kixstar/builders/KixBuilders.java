package me.kixstar.builders;

import co.aikar.commands.PaperCommandManager;
import com.onarandombox.MultiverseCore.MultiverseCore;
import me.kixstar.builders.commands.BuilderCommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class KixBuilders extends JavaPlugin {

    private static final Plugin instance = Bukkit.getServer().getPluginManager().getPlugin("KixBuilders");
    private PaperCommandManager commandManager;

    public void onEnable() {
        this.initialiseCommands();


    }

    public void onDisable() {}

    private void initialiseCommands() {
        commandManager = new PaperCommandManager(this);
        commandManager.registerDependency(MultiverseCore.class, Multiverse.getMultiverseCore());
        commandManager.registerCommand(new BuilderCommandHandler());

    }

    public static KixBuilders getInstance() {
        return null == instance ? null : (KixBuilders) instance;
    }

}
