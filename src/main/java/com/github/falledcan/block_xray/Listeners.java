package com.github.falledcan.block_xray;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        String p = event.getPlayer().getName();
        Block_Xray.i_p.remove(p);
        Block_Xray.g_p.remove(p);
        Block_Xray.d_p.remove(p);
        Block_Xray.e_p.remove(p);
        Block_Xray.r_p.remove(p);
    }

}
