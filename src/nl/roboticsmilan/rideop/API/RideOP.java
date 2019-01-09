package nl.roboticsmilan.rideop.API;

/*
 * Created by RoboticsMilan on 12/15/18 8:31 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.GUI.GUILoader;
import nl.roboticsmilan.rideop.Main;
import nl.roboticsmilan.rideop.Util.MessageUtil;
import nl.roboticsmilan.rideop.Util.RideopReader;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RideOP {

    public void openOP(String name, Player player) {
        File attraction = new File(Main.pl.getDataFolder() + "/rideopfiles", "RideOp-" + name + ".rideop");
        if (attraction.exists()) {
            GUILoader.loadGUI(name, (Player) player);
        } else {
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getnotfound());


        }
    }

    public void createOP(String name, Player player) {
        try {
            RideopReader.create(name, (Player) player);
        } catch (IOException e) {
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
        }

    }

    public void deleteOP(String name, Player player) {
        try {
            RideopReader.delete(name, (Player) player);
        } catch (IOException e) {
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
        }

    }
}
