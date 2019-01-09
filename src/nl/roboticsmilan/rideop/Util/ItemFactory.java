package nl.roboticsmilan.rideop.Util;

/*
 * Created by RoboticsMilan on 12/15/18 8:34 PM
 * Copyright (c) today.year.
 */

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemFactory {

    public static void create(String name, String lore, Material mat, Inventory inv, int invp) {
        ItemStack stack;
        ItemMeta meta;
        stack = new ItemStack(mat);
        meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + name);
        meta.setLore(Arrays.asList(ChatColor.GRAY + lore));
        stack.setItemMeta(meta);
        inv.setItem(invp, stack);

    }
}
