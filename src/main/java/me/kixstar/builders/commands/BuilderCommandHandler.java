package me.kixstar.builders.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.entity.Player;

@CommandAlias("builder")
public class BuilderCommandHandler extends BaseCommand {

    @Dependency
    private static MultiverseCore multiverseCore;

    @Subcommand("create")
    @Description("Create a new world.")
    @CommandPermission("kixstar.builders.create")
    public static void create(Player player, String[] args) {
        String name = String.format("%s-001", player.getName());
        if (multiverseCore.getMVWorldManager().getMVWorld(name) != null) {
            player.sendMessage(String.format("%sYour world already exists: /mv tp %s", Color.RED, name));
            return;
        }
        multiverseCore.cloneWorld("template", name, "NORMAL");
        MultiverseWorld world = multiverseCore.getMVWorldManager().getMVWorld(name);
        world.setDifficulty(Difficulty.PEACEFUL);
        world.setGameMode(GameMode.CREATIVE);
        world.getCBWorld().setGameRule(GameRule.DO_FIRE_TICK, false);
        world.getCBWorld().setGameRule(GameRule.MOB_GRIEFING, false);
        world.getCBWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.getCBWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setEnableWeather(false);
        world.setAlias(name);
        multiverseCore.teleportPlayer(player.getServer().getConsoleSender(), player, world.getSpawnLocation());
        player.sendMessage(String.format("%sSuccessfully created your world. Happy building.", Color.GREEN));
    }

}
