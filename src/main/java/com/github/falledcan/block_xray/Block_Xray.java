package com.github.falledcan.block_xray;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Block_Xray extends JavaPlugin {

    static Block_Xray plugin;
    static ParticleNativeAPI particleApi;

    static ArrayList<String> d_p = new ArrayList<>();
    static ArrayList<String> i_p = new ArrayList<>();
    static ArrayList<String> g_p = new ArrayList<>();
    static ArrayList<String> r_p = new ArrayList<>();
    static ArrayList<String> e_p = new ArrayList<>();


    @Override
    public void onEnable() {
        plugin = this;
        particleApi = ParticleNativeCore.loadAPI(this);
        getServer().getPluginManager().registerEvents(new Listeners(),this);
        getCommand("xray").setExecutor(new XrayCmd());
        getCommand("xray").setTabCompleter(new XrayCmdTab());
        new Run().onRun();

        // Plugin startup logic

    }

    static Block_Xray getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
