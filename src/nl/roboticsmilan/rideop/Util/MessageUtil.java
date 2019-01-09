package nl.roboticsmilan.rideop.Util;

/*
 * Created by RoboticsMilan on 12/20/18 9:45 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageUtil {

    // niet gevonden
    // aangemaakt
    // removed
    // niet goed gebruikt
    // argument

    /* notfound: ''
created: ''
removed: ''
not-right-use: ''
argument-not-found: ''
*/


    public static void load() throws IOException {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        if (!messages.exists()) {
            messages.createNewFile();
            YamlConfiguration config = YamlConfiguration.loadConfiguration(messages);
            config.set("not-found", "Rideop Not Found");
            config.set("created", "Rideop Created");
            config.set("removed", "Rideop Removed");
            config.set("not-right-use", "Wrong Usage.");
            config.set("argument-not-found", "Argument not Found. /rideop help");
            config.save(messages);


        }
    }
    public static String getnotfound() {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messages);
        String message = messageconfig.get("not-found").toString();
        return message;

    }

    public static String getcreated() {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messages);
        String message = messageconfig.get("created").toString();
        return message;

    }

    public static String getremoved() {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messages);
        String message = messageconfig.get("removed").toString();
        return message;

    }

    public static String getuseerror() {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messages);
        String message = messageconfig.get("not-right-use").toString();
        return message;

    }

    public static String getargumenterr() {
        File messages = new File(Main.pl.getDataFolder(), "messages.yml");
        YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messages);
        String message = messageconfig.get("argument-not-found").toString();
        return message;

    }

}
