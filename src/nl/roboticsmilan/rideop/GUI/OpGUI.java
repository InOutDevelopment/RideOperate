package nl.roboticsmilan.rideop.GUI;

/*
 * Created by RoboticsMilan
 * Copyright (c) 2018.
 * This Plugin is made by RoboticsMilan. You're not allowed to use the code for your project
 */

import nl.roboticsmilan.rideop.Util.ItemFactory;
import org.bukkit.inventory.Inventory;


public class OpGUI {

    public OpGUI(Inventory inv) {
        ItemFactory.create("Status", "Change the status from this attraction", CustomItems.getstatus(), inv, 9);
        ItemFactory.create("Gates", "Open/Close the Gates from this attraction", CustomItems.getgates(), inv,12);
        ItemFactory.create("Dispatch", "Dispatch this Attraction", CustomItems.getdispatch(), inv, 13);
        ItemFactory.create("Safety Bar", "Open/Close the Safety Bars from this attraction", CustomItems.getbars(), inv, 14);
        ItemFactory.create("Power", "Turn on/off the power from this attraction", CustomItems.getpower(), inv, 17);
    }
}
