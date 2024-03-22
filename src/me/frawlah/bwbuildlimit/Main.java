package me.frawlah.bwbuildlimit;

import com.andrei1058.bedwars.api.BedWars;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {

            getLogger().severe("BedWars1058 was not found!");

            Bukkit.getPluginManager().disablePlugin(this);

            return;

        } else {

            getLogger().info("BedWars1058 was found! Hooking up with her...");

            BedWars bedWarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

            getServer().getPluginManager().registerEvents(new BuildLimit(), this);

            getLogger().info("BedWars1058-BuildLimit addon enabled!");

        }

    }

    @Override
    public void onDisable() {

        getLogger().info("BedWars1058-BuildLimit addon disabled!");

        getLogger().info("Goodbye! ❤");

    }
}
