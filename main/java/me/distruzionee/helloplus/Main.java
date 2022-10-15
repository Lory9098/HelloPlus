package me.distruzionee.helloplus;

import me.distruzionee.helloplus.commands.test;
import me.distruzionee.helloplus.utils.format;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new test(this));
        Bukkit.getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        e.setJoinMessage(format.color(this.getConfig().getString("public-message") + " " + e.getPlayer().getName()));

        if(this.getConfig().getBoolean("enable-private-message") == true){
            e.getPlayer().sendMessage(format.color(this.getConfig().getString("private-message")));
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        e.setQuitMessage(format.color(this.getConfig().getString("exit-public-message") + " " + e.getPlayer().getName()));
    }

}
