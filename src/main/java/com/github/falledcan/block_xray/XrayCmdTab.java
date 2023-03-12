package com.github.falledcan.block_xray;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XrayCmdTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            List<String> pm = new ArrayList<String>();
            pm.add("i");
            pm.add("g");
            pm.add("d");
            pm.add("r");
            pm.add("e");
            Collections.sort(pm);
            return pm;

        }
        return null;
    }
}
