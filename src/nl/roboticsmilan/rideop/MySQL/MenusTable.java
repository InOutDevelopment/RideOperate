package nl.roboticsmilan.rideop.MySQL;

/*
 * Created by RoboticsMilan on 12/21/18 7:37 PM
 * Copyright (c) today.year.
 */

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenusTable {

    public static void addMenu(long id, String name, Player sender) {
        PreparedStatement statement = null;
        try {
            statement = DBConnection.connection.prepareStatement("UPDATE `operatemenu` SET `Creator` = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(1, sender.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("INSERT INTO operatemenu (`Creator`, `ID`, `MenuName`) VALUES ('" + sender.getName() + "', '" + id + "', '" + name + "');");
        } catch (SQLException e) {
            sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
        }

    }

    public static void removeMenu(long id, String name, Player sender) {
        PreparedStatement statement = null;
        try {
            statement = DBConnection.connection.prepareStatement("UPDATE `operatemenu` SET `Creator` = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(1, sender.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("DELETE FROM operatemenu WHERE ID = " + id +";");
        } catch (SQLException e) {
            sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
        }



    }
}
