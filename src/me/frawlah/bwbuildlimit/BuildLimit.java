package me.frawlah.bwbuildlimit;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@SuppressWarnings("all")
public class BuildLimit implements Listener {

    @EventHandler
    public void playerBlockPlace(BlockPlaceEvent event) {

        Player p = event.getPlayer();

        IArena arena = Arena.getArenaByPlayer(p);

        if (arena.getStatus() == GameState.playing) {

            if (event.getBlockPlaced().getLocation().getBlockY() >= arena.getConfig().getInt(ConfigPath.ARENA_CONFIGURATION_MAX_BUILD_Y)) {

                event.getPlayer().sendMessage(ChatColor.RED + "Build height limit reached!");

                return;

            }

        }

    }

}
