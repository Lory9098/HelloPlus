package me.distruzionee.helloplus.commands;

import me.distruzionee.helloplus.Main;
import me.distruzionee.helloplus.utils.format;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {

    private final Main main;

    public test(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        player.sendMessage("------------------------------------------------");
        player.sendMessage(format.color(main.getConfig().getString("public-message") + player.getName()));
        player.sendMessage(format.color(main.getConfig().getString("exit-public-message") + player.getName()));

        if(main.getConfig().getBoolean("enable-private-message") == true){
            player.sendMessage(format.color(main.getConfig().getString("private-message") + ChatColor.GREEN + " " + "[]"));
        }else{
            player.sendMessage(format.color(main.getConfig().getString("private-message") + ChatColor.RED + " " + "[]"));
        }



        return true;
    }
}
