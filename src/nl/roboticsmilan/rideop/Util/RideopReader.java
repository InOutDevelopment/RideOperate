package nl.roboticsmilan.rideop.Util;

/*
 * Created by RoboticsMilan on 12/18/18 4:47 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RideopReader {

    public static void create(String name, Player player) throws IOException {
        File attraction = new File(Main.pl.getDataFolder()+"/rideopfiles","RideOp-" + name +".rideop");
        File folder = new File(Main.pl.getDataFolder()+"/rideopfiles");
        folder.mkdir();
        if (attraction.exists()) {
            player.sendMessage("You're already created this rideop.");

        } else {
            attraction.createNewFile();
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(attraction);
            configuration.set("rideoperate.ID", attraction.getFreeSpace() + 1);
            configuration.set("rideoperate.Name", attraction.getName());
            configuration.set("rideoperate.RideState.Power.command", "say Change me");
            configuration.set("rideoperate.RideState.Status.command", "say Change me");
            configuration.set("rideoperate.RideState.Gates.command", "say Change me");
            configuration.set("rideoperate.RideState.Bars.command", "say Change me");
            configuration.set("rideoperate.RideState.Dispatch.command", "say Change me");
            player.sendMessage(MessageUtil.getcreated());
            configuration.save(attraction);
        }
    }

    public static void delete(String name, Player player) throws IOException {
        File attraction = new File(Main.pl.getDataFolder()+"/rideopfiles","RideOp-" + name +".rideop");
        if (attraction.exists()) {
            attraction.delete();
            player.sendMessage(MessageUtil.getremoved());
        } else {
            player.sendMessage(MessageUtil.getnotfound());
        }

    }

}
