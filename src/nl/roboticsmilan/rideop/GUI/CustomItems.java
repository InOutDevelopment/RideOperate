package nl.roboticsmilan.rideop.GUI;

/*
 * Created by RoboticsMilan on 12/20/18 9:32 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import org.bukkit.Material;

public class CustomItems {

    public static Material getstatus() {
        String matstatus = Main.pl.getConfig().get("items.status").toString();
        Material mat = Material.getMaterial(matstatus.toUpperCase());
        return mat;
    }

    public static Material getgates() {
        String matgates = Main.pl.getConfig().get("items.gates").toString();
        Material mat = Material.getMaterial(matgates.toUpperCase());
        return mat;
    }

    public static Material getdispatch() {
        String matdispatch = Main.pl.getConfig().get("items.dispatch").toString();
        Material mat = Material.getMaterial(matdispatch.toUpperCase());
        return mat;
    }

    public static Material getbars() {
        String matbars = Main.pl.getConfig().get("items.bars").toString();
        Material mat = Material.getMaterial(matbars.toUpperCase());
        return mat;
    }

    public static Material getpower() {
        String matpower = Main.pl.getConfig().get("items.power").toString();
        Material mat = Material.getMaterial(matpower.toUpperCase());
        return mat;
    }

}
