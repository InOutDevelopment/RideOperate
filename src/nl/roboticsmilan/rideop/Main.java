package nl.roboticsmilan.rideop;

/*
 * Created by RoboticsMilan on 12/15/18 8:30 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Listener.JoinHandler;
import nl.roboticsmilan.rideop.Listener.OPListener;
import nl.roboticsmilan.rideop.Listener.OPSign;
import nl.roboticsmilan.rideop.MySQL.DBConnection;
import nl.roboticsmilan.rideop.Util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends JavaPlugin {

    public static Plugin pl;

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        checkUpdate();
        pl = this;
        getCommand("rideop").setExecutor(new RideopCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new OPListener(), Main.pl);
        Bukkit.getServer().getPluginManager().registerEvents(new OPSign(), Main.pl);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinHandler(), Main.pl);
        try {
            MessageUtil.load();
        } catch (IOException e) {
            Bukkit.getLogger().info("Whoops, There is an error. " + e);
        }
        //new DBConnection();
    }

    private static String key = "key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=";

    public static void checkUpdate() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=59525").openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.getOutputStream().write((key + 59525).getBytes("UTF-8"));
            String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            if (!version.equals("V1.4")) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "You're not running the newest version of RideOperate+");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Please download it on Spigot: https://www.spigotmc.org/resources/%E2%98%85-rideoperate-a-plugin-for-your-themepark-server-%E2%98%85.59525/");
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.hasPermission("rideop.rideop")) {
                        player.sendMessage(ChatColor.DARK_PURPLE + "You're not running the newest version of RideOperate+");
                        player.sendMessage(ChatColor.GRAY + "Please download it on Spigot: https://www.spigotmc.org/resources/%E2%98%85-rideoperate-a-plugin-for-your-themepark-server-%E2%98%85.59525/");
                    }
                }
            } else {
                Bukkit.getServer().getConsoleSender().sendMessage("You're running the newest version of RideOperate+");
            }
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage("Can't connect to SpigotMC");
            e.printStackTrace();

        }
    }

    @Override
    public void onDisable() {

    }

}
