package nl.roboticsmilan.rideop.GUI;

/*
 * Created by RoboticsMilan on 12/15/18 9:01 PM
 * Copyright (c) today.year.
 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUILoader {
    public static void loadGUI(String name, Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "RideOp-" +name);
        new OpGUI(inv);
        player.openInventory(inv);

    }
}
