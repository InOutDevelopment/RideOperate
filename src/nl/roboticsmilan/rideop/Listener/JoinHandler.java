package nl.roboticsmilan.rideop.Listener;

/*
 * Created by RoboticsMilan on 1/9/19 2:57 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Main.checkUpdate();

    }

}
