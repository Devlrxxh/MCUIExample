package dev.lrxh.mcuiexample;

import dev.lrxh.mcui.MCUI;
import dev.lrxh.mcui.component.UIComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCUIExample extends JavaPlugin implements Listener {
    private UIComponent healthUIComponent;

    @Override
    public void onEnable() {
        healthUIComponent = MCUI.INSTANCE.getComponentManager().registerComponent(new HealthUIComponent());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        healthUIComponent.addViewer(event.getPlayer());
    }
}
