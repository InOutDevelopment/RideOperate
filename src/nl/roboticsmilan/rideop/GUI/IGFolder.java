package nl.roboticsmilan.rideop.GUI;

/*
 * Created by RoboticsMilan on 12/21/18 8:31 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import nl.roboticsmilan.rideop.Util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


import java.io.File;
import java.util.ArrayList;

public class IGFolder {

    public static ArrayList<File> allfiles = new ArrayList<>();



    public static void test() {
        File[] allRideOP = new File(Main.pl.getDataFolder() + "/rideopfiles").listFiles();
        for (File file : allRideOP) {
            Bukkit.getServer().broadcastMessage("RideOP Loaded: " + file.getName());
            allfiles.add(file);

        }
        Bukkit.broadcastMessage("Folder Size: " + allfiles.size());
    }
    public static void loadGUI(int foldersize, Player p) {
        if (foldersize < 9) {
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "RideOperate+ Folder");
            File file1 = allfiles.get(0);
            File file2 = allfiles.get(1);
            File file3 = allfiles.get(2);
            File file4 = allfiles.get(3);
            File file5 = allfiles.get(4);
            File file6 = allfiles.get(5);
            File file7 = allfiles.get(6);
            File file8 = allfiles.get(7);
            ItemFactory.create(file1.getName(), "", Material.PAPER, inv, 0);
            ItemFactory.create(file2.getName(), "", Material.PAPER, inv, 1);
            ItemFactory.create(file3.getName(), "", Material.PAPER, inv, 2);
            ItemFactory.create(file4.getName(), "", Material.PAPER, inv, 3);
            ItemFactory.create(file5.getName(), "", Material.PAPER, inv, 4);
            ItemFactory.create(file6.getName(), "", Material.PAPER, inv, 5);
            ItemFactory.create(file7.getName(), "", Material.PAPER, inv, 6);
            ItemFactory.create(file8.getName(), "", Material.PAPER, inv, 7);
            p.openInventory(inv);

        }
        if (foldersize > 9 & foldersize < 18) {

        }
        if (foldersize > 18 & foldersize < 27) {

        }
        if (foldersize > 27 & foldersize < 36) {

        }
        if (foldersize > 36 & foldersize < 45) {

        }
        if (foldersize > 45 & foldersize < 54) {

        }


    }

}
