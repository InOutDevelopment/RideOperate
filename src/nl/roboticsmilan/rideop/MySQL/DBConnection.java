package nl.roboticsmilan.rideop.MySQL;

/*
 * Created by RoboticsMilan on 12/15/18 9:08 PM
 * Copyright (c) today.year.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import nl.roboticsmilan.rideop.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.SQLException;

public class DBConnection {

    public static Connection connection;

    private String host = (String) Main.pl.getConfig().get("mysql.host");
    private int port = Main.pl.getConfig().getInt("mysql.port");
    private String database = (String) Main.pl.getConfig().get("mysql.database");
    private String username = (String) Main.pl.getConfig().get("mysql.username");
    private String password = (String) Main.pl.getConfig().get("mysql.password");

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "MySQL " + ChatColor.DARK_RED + "ERROR:" + ChatColor.RED + e);

        }
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(host);
            dataSource.setPort(port);
            dataSource.setDatabaseName(database);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            try {
                connection = (Connection) dataSource.getConnection();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "MySQL " + ChatColor.DARK_RED + "ERROR:" + ChatColor.RED + e);
            }

        }

    }

