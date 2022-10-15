package me.distruzionee.helloplus.utils;

import org.bukkit.ChatColor;

public class format {
    public static String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
