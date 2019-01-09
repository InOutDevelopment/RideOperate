package nl.roboticsmilan.rideop;

/*
 * Created by RoboticsMilan on 12/18/18 4:54 PM
 * Copyright (c) today.year.
 */

import nl.roboticsmilan.rideop.GUI.GUILoader;
import nl.roboticsmilan.rideop.GUI.IGFolder;
import nl.roboticsmilan.rideop.MySQL.MenusTable;
import nl.roboticsmilan.rideop.Util.MessageUtil;
import nl.roboticsmilan.rideop.Util.RideopReader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RideopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender.hasPermission("rideop.open")) {
            if (strings.length == 0) {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getargumenterr());
                return false;
            }
            if (strings[0].equalsIgnoreCase("open")) {
                if (strings.length == 2) {
                    File attraction = new File(Main.pl.getDataFolder() + "/rideopfiles", "RideOp-" + strings[1] + ".rideop");
                    if (attraction.exists()) {
                        GUILoader.loadGUI(strings[1], (Player) sender);
                    } else {
                        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getnotfound());


                    }

                } else {
                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getuseerror() + " /rideop open (name)");

                }


            }
        }
        if (sender.hasPermission("rideop.rideop")) {
            if (strings.length == 0) {
                sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getargumenterr());
                return false;
            }
            if (strings[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.DARK_PURPLE + "-=-()-=-RideOperate+ Help-=-()-=-");
                sender.sendMessage(ChatColor.GRAY + "/rideop create (name) - Create a ControlPanel");
                sender.sendMessage(ChatColor.GRAY + "/rideop delete (name) - Delete a ControlPanel");
                sender.sendMessage(ChatColor.GRAY + "/rideop open (name) - Open a ControlPanel");
                sender.sendMessage(ChatColor.DARK_PURPLE + "-=-()-=-RideOperate+ Help-=-()-=-");
            }
            if (strings[0].equalsIgnoreCase("create")) {
                if (strings.length == 2) {
                    //File attraction = new File(Main.pl.getDataFolder()+"/rideopfiles");
                    //MenusTable.addMenu((long) (attraction.getFreeSpace() + Math.random()), strings[1], (Player) sender);
                    try {
                        RideopReader.create(strings[1], (Player) sender);
                    } catch (IOException e) {
                        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
                    }
                } else {
                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getuseerror() + " /rideop create (name)");
                }
            }
            if (strings[0].equalsIgnoreCase("delete")) {
                //File attraction = new File(Main.pl.getDataFolder()+"/rideopfiles","RideOp-" + strings[1] +".rideop");
                //YamlConfiguration config = YamlConfiguration.loadConfiguration(attraction);
                //MenusTable.removeMenu((Long) config.get("ID"), strings[1], (Player) sender);
                if (strings.length == 2) {
                    try {
                        RideopReader.delete(strings[1], (Player) sender);
                    } catch (IOException e) {
                        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + "Whoops. There is a Error: " + e.toString() + " Please contact the developer.");
                    }
                } else {
                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getuseerror() + " /rideop delete (name)");
                }
            }
            if (strings[0].equalsIgnoreCase("setcommand")) {
                if (strings.length > 4 && strings.length < 8) {
                    File f = new File(Main.pl.getDataFolder() + "/rideopfiles", "RideOp-" + strings[1] + ".rideop");
                    YamlConfiguration fconfig = YamlConfiguration.loadConfiguration(f);

                    if (strings[2].equalsIgnoreCase("Power")) {
                        if (strings.length == 4) {
                            fconfig.set("rideoperate.RideState.Power.command", strings[3]);
                            try {
                                fconfig.save(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (strings.length == 5) {
                            fconfig.set("rideoperate.RideState.Power.command", strings[3] + " " +  strings[4]);
                            try {
                                fconfig.save(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (strings.length == 6) {
                            fconfig.set("rideoperate.RideState.Power.command", strings[3] + " " + strings[4] + " " + strings[5]);
                            try {
                                fconfig.save(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (strings.length == 7) {
                            fconfig.set("rideoperate.RideState.Power.command", strings[3] + " " + strings[4] + " " + strings[5] + " " + strings[6]);
                            try {
                                fconfig.save(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        sender.sendMessage("Command set");

                    } else {
                        if (strings[2].equalsIgnoreCase("Status")) {
                            if (strings.length == 4) {
                                fconfig.set("rideoperate.RideState.Status.command", strings[3]);
                                try {
                                    fconfig.save(f);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (strings.length == 5) {
                                fconfig.set("rideoperate.RideState.Status.command", strings[3] + " " + strings[4]);
                                try {
                                    fconfig.save(f);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (strings.length == 6) {
                                fconfig.set("rideoperate.RideState.Status.command", strings[3] + " " +strings[4] +" " + strings[5]);
                                try {
                                    fconfig.save(f);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (strings.length == 7) {
                                fconfig.set("rideoperate.RideState.Status.command", strings[3] + " " + strings[4] + " " + strings[5] + " " + strings[6]);
                                try {
                                    fconfig.save(f);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            sender.sendMessage("Command set");

                        } else {
                            if (strings[2].equalsIgnoreCase("Gates")) {
                                if (strings.length == 4) {
                                    fconfig.set("rideoperate.RideState.Gates.command", strings[3]);
                                    try {
                                        fconfig.save(f);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (strings.length == 5) {
                                    fconfig.set("rideoperate.RideState.Gates.command", strings[3] +" " + strings[4]);
                                    try {
                                        fconfig.save(f);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (strings.length == 6) {
                                    fconfig.set("rideoperate.RideState.Gates.command", strings[3] +" " + strings[4] +" " + strings[5]);
                                    try {
                                        fconfig.save(f);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (strings.length == 7) {
                                    fconfig.set("rideoperate.RideState.Gates.command", strings[3] + " " + strings[4] + " " + strings[5] + " " + strings[6]);
                                    try {
                                        fconfig.save(f);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                sender.sendMessage("Command set");

                            } else {
                                if (strings[2].equalsIgnoreCase("Dispatch")) {
                                    if (strings.length == 4) {
                                        fconfig.set("rideoperate.RideState.Dispatch.command", strings[3]);
                                        try {
                                            fconfig.save(f);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (strings.length == 5) {
                                        fconfig.set("rideoperate.RideState.Dispatch.command", strings[3] +" " + strings[4]);
                                        try {
                                            fconfig.save(f);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (strings.length == 6) {
                                        fconfig.set("rideoperate.RideState.Dispatch.command", strings[3] +" " + strings[4] +" " + strings[5]);
                                        try {
                                            fconfig.save(f);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (strings.length == 7) {
                                        fconfig.set("rideoperate.RideState.Dispatch.command", strings[3] + " " + strings[4] + " " + strings[5] + " " + strings[6]);
                                        try {
                                            fconfig.save(f);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    sender.sendMessage("Command set");

                                } else {
                                    if (strings[2].equalsIgnoreCase("Bars")) {
                                        if (strings.length == 4) {
                                            fconfig.set("rideoperate.RideState.Bars.command", strings[3]);
                                            try {
                                                fconfig.save(f);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (strings.length == 5) {
                                            fconfig.set("rideoperate.RideState.Bars.command", strings[3] +" " + strings[4]);
                                            try {
                                                fconfig.save(f);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (strings.length == 6) {
                                            fconfig.set("rideoperate.RideState.Bars.command", strings[3] +" " + strings[4] +" " + strings[5]);
                                            try {
                                                fconfig.save(f);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (strings.length == 7) {
                                            fconfig.set("rideoperate.RideState.Bars.command", strings[3] + " " + strings[4] + " " + strings[5] + " " + strings[6]);
                                            try {
                                                fconfig.save(f);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        sender.sendMessage("Command set");

                                    } else {
                                        sender.sendMessage("Can't find the RideState");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "RideOperate+" + ChatColor.GRAY + "]" + " " + ChatColor.WHITE + MessageUtil.getuseerror() + " /rideop setcommand (name) (Power/Status/etc.) (command without /)");
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

