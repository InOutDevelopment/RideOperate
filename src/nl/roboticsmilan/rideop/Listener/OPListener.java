package nl.roboticsmilan.rideop.Listener;

/*
 * Created by RoboticsMilan on 12/18/18 5:30 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;

public class OPListener implements Listener {

    @EventHandler
    public void clickonccenter(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
                if (e.getCurrentItem() != null) {
                    File f = new File(Main.pl.getDataFolder() + "/rideopfiles", e.getClickedInventory().getTitle() + ".rideop");
                    YamlConfiguration fconfig = YamlConfiguration.loadConfiguration(f);
                    if (f.exists()) {
                        e.setCancelled(true);
                        switch (e.getCurrentItem().getType()) {
                            case FENCE:
                                Player player = (Player) e.getWhoClicked();
                                player.performCommand(fconfig.get("rideoperate.RideState.Status.command").toString());
                                break;
                            case FENCE_GATE:
                                Player player1 = (Player) e.getWhoClicked();
                                player1.performCommand(fconfig.get("rideoperate.RideState.Gates.command").toString());
                                break;
                            case MINECART:
                                Player player2 = (Player) e.getWhoClicked();
                                player2.performCommand(fconfig.get("rideoperate.RideState.Dispatch.command").toString());
                                break;
                            case TRAP_DOOR:
                                Player player3 = (Player) e.getWhoClicked();
                                player3.performCommand(fconfig.get("rideoperate.RideState.Bars.command").toString());
                                break;
                            case REDSTONE_TORCH_ON:
                                Player player4 = (Player) e.getWhoClicked();
                                player4.performCommand(fconfig.get("rideoperate.RideState.Power.command").toString());
                                break;
                            default:
                                break;

                        }
                    } else {
                        e.setCancelled(false);
                    }
                }
            } else {
                e.setCancelled(false);
        }
        }
    }

