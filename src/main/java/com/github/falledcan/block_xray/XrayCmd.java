package com.github.falledcan.block_xray;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.TextComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class XrayCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();

            if(args.length == 1) {

                switch (args[0]) {
                    case "d":
                        if (Block_Xray.d_p.contains(player.getName())) {
                            Block_Xray.d_p.remove(player.getName());
                        } else {
                            Block_Xray.d_p.add(player.getName());
                        }
                        break;
                    case "i":
                        if (Block_Xray.i_p.contains(player.getName())) {
                            Block_Xray.i_p.remove(player.getName());
                        } else {
                            Block_Xray.i_p.add(player.getName());
                        }
                        break;
                    case "r":
                        if (Block_Xray.r_p.contains(player.getName())) {
                            Block_Xray.r_p.remove(player.getName());
                        } else {
                            Block_Xray.r_p.add(player.getName());
                        }
                        break;
                    case "e":
                        if (Block_Xray.e_p.contains(player.getName())) {
                            Block_Xray.e_p.remove(player.getName());
                        } else {
                            Block_Xray.e_p.add(player.getName());
                        }
                        break;
                    case "g":
                        if (Block_Xray.g_p.contains(player.getName())) {
                            Block_Xray.g_p.remove(player.getName());
                        } else {
                            Block_Xray.g_p.add(player.getName());
                        }
                        break;
                    default:
                        player.sendMessage("Invalid command");
                        break;
                }
                player.performCommand("xray");
                return true;
            }else {

                String i_command = "/xray i";
                TextComponent i_component = new TextComponent(ChatColor.GRAY + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIron" + ChatColor.WHITE + ": " + (Block_Xray.i_p.contains(player.getName())? "on" : "off"));
                i_component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,i_command));
                String g_command = "/xray g";
                TextComponent g_component = new TextComponent(ChatColor.GOLD + "Gold" + ChatColor.WHITE + ": " + (Block_Xray.g_p.contains(player.getName())? "on" : "off"));
                g_component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,g_command));
                String d_command = "/xray d";
                TextComponent d_component = new TextComponent(ChatColor.AQUA + "Diamond" + ChatColor.WHITE + ": " + (Block_Xray.d_p.contains(player.getName())? "on" : "off"));
                d_component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,d_command));
                String e_command = "/xray e";
                TextComponent e_component = new TextComponent(ChatColor.GREEN + "Emerald" + ChatColor.WHITE + ": " + (Block_Xray.e_p.contains(player.getName())? "on" : "off"));
                e_component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,e_command));
                String r_command = "/xray r";
                TextComponent r_component = new TextComponent(ChatColor.RED + "RedStone" + ChatColor.WHITE + ": " + (Block_Xray.r_p.contains(player.getName())? "on" : "off"));
                r_component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,r_command));
                player.spigot().sendMessage(i_component);
                player.spigot().sendMessage(g_component);
                player.spigot().sendMessage(d_component);
                player.spigot().sendMessage(e_component);
                player.spigot().sendMessage(r_component);
                return true;
            }
        }
        return false;
    }

}
