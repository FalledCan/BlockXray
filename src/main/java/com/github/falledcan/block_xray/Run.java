package com.github.falledcan.block_xray;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Run {

    private ParticleNativeAPI api = Block_Xray.particleApi;
    private ArrayList<String> d_p = Block_Xray.d_p;
    public void onRun(){
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {

                if(!d_p.isEmpty() || !Block_Xray.e_p.isEmpty() || !Block_Xray.g_p.isEmpty()  || !Block_Xray.i_p.isEmpty()  || !Block_Xray.r_p.isEmpty()) {

                    for(int i = 0; i < d_p.size(); ++i) {
                        Player player = Bukkit.getPlayer(d_p.get(i));

                        getBlocks(player, "d");
                    }
                    for(int i = 0; i < Block_Xray.e_p.size(); ++i) {
                        Player player = Bukkit.getPlayer(Block_Xray.e_p.get(i));

                        getBlocks(player, "e");
                    }
                    for(int i = 0; i < Block_Xray.g_p.size(); ++i) {
                        Player player = Bukkit.getPlayer(Block_Xray.g_p.get(i));

                        getBlocks(player, "g");
                    }
                    for(int i = 0; i < Block_Xray.i_p.size(); ++i) {
                        Player player = Bukkit.getPlayer(Block_Xray.i_p.get(i));

                        getBlocks(player, "i");
                    }
                    for(int i = 0; i < Block_Xray.r_p.size(); ++i) {
                        Player player = Bukkit.getPlayer(Block_Xray.r_p.get(i));

                        getBlocks(player, "r");
                    }
                }

            }
        };
        task.runTaskTimer(Block_Xray.getPlugin(),1L, 10L);
    }

    private void getBlocks(Player player,String ore) {
        int radius = 10; // 検索範囲の半径
        Location loc = player.getLocation();
        World world = loc.getWorld();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    Block block = world.getBlockAt(x + dx, y + dy, z + dz);
                    if (ore.equals("d") && block != null && (block.getType() == Material.DIAMOND_ORE || block.getType() == Material.DEEPSLATE_DIAMOND_ORE)) {
                        DustLine(player, block, ore);
                    }
                    if (ore.equals("i") && block != null && (block.getType() == Material.IRON_ORE || block.getType() == Material.DEEPSLATE_IRON_ORE)) {
                        DustLine(player, block, ore);
                    }
                    if (ore.equals("g") && block != null && (block.getType() == Material.GOLD_ORE || block.getType() == Material.DEEPSLATE_GOLD_ORE)) {
                        DustLine(player, block, ore);
                    }
                    if (ore.equals("r") && block != null && (block.getType() == Material.REDSTONE_ORE || block.getType() == Material.DEEPSLATE_REDSTONE_ORE)) {
                        DustLine(player, block, ore);
                    }
                    if (ore.equals("e") && block != null && (block.getType() == Material.EMERALD_ORE || block.getType() == Material.DEEPSLATE_EMERALD_ORE)) {
                        DustLine(player, block, ore);
                    }
                }
            }
        }
    }

    private void DustLine(Player player, Block block, String ore) {
        Location playerLoc = player.getLocation();
        double player_x = playerLoc.getBlockX(), player_y = playerLoc.getBlockY()+1, player_z = playerLoc.getBlockZ(); // 始点の座標
        double block_x = block.getX(), block_y = block.getY(), block_z = block.getZ(); // 終点の座標

        double dx = block_x - player_x;
        double dy = block_y - player_y;
        double dz = block_z - player_z;

        int numPoints = 20;  // 打つ点の数
        for (int i = 0; i < numPoints; i++) {
            double t = (double) i / (numPoints - 1);
            double x = player_x + t * dx;
            double y = player_y + t * dy;
            double z = player_z + t * dz;
            Location setLoc = new Location(player.getWorld(),x,y,z);

            switch (ore) {
                case "d":
                    api.LIST_1_13.DUST.color(Color.AQUA,1)
                            .packet(false,setLoc)
                            .sendTo(player);
                    break;
                case "i":
                    api.LIST_1_13.DUST.color(Color.WHITE,1)
                            .packet(false,setLoc)
                            .sendTo(player);
                    break;
                case "r":
                    api.LIST_1_13.DUST.color(Color.RED,1)
                            .packet(false,setLoc)
                            .sendTo(player);
                    break;
                case "e":
                    api.LIST_1_13.DUST.color(Color.LIME,1)
                            .packet(false,setLoc)
                            .sendTo(player);
                    break;
                case "g":
                    api.LIST_1_13.DUST.color(Color.YELLOW,1)
                            .packet(false,setLoc)
                            .sendTo(player);
                    break;
                default:
                    player.sendMessage("Invalid command");
                    break;
            }

        }
    }
}

