package xyz.pugly.factionsantienemyteleport;

import org.bukkit.plugin.java.JavaPlugin;

public final class FactionsAntiEnemyTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
