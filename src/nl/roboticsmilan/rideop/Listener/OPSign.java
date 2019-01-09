package nl.roboticsmilan.rideop.Listener;

/*
 * Created by RoboticsMilan on 12/21/18 12:07 PM
 * Copyright (c) today.year.
 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class OPSign implements Listener {

    @EventHandler
    public void signupdate(SignChangeEvent changeEvent) throws NullPointerException {

        String line1 = changeEvent.getLine(1);
        String line2 = changeEvent.getLine(2);
        BlockState state = changeEvent.getBlock().getState();
        Player player = changeEvent.getPlayer();
        if (line1 != null && line1.equalsIgnoreCase("[RideOp]")) {
            Sign sign = (Sign) state;
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + " Sign Created for: " + line2);
            sign.setLine(1, ChatColor.DARK_PURPLE + "[RideOp]");
        }


    }
    @EventHandler
    public void clickonsign(PlayerInteractEvent e) throws NullPointerException {
        Block block = e.getClickedBlock();
        Player player = e.getPlayer();
        BlockState state = block.getState();
        if (state != null) {
            if (state instanceof org.bukkit.block.Sign) {
                org.bukkit.block.Sign sign = (org.bukkit.block.Sign) state;
                String line1 = sign.getLine(1);
                String line2 = sign.getLine(2);
                if (line1 != null && line1.equalsIgnoreCase(ChatColor.DARK_PURPLE + "[RideOp]") || line1.equalsIgnoreCase("[RideOp]")) {
                    player.performCommand("rideop open " + line2);
                }
            }
        }
    }



    @EventHandler
    public void placesign(BlockPlaceEvent event) throws NullPointerException {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (block.getState() != null) {
            BlockState state = block.getState();
            if (state instanceof org.bukkit.block.Sign) {
                org.bukkit.block.Sign sign = (org.bukkit.block.Sign) state;
                String line1 = sign.getLine(1);
                String line2 = sign.getLine(2);
                if (line1 != null && line1.equalsIgnoreCase("[RideOp]")) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + " Sign Created for: " + line2);
                    sign.setLine(1, ChatColor.DARK_PURPLE + "[RideOp]");
                }
            }
        }
    }
}
