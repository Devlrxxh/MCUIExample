package dev.lrxh.mcuiexample;

import dev.lrxh.mcui.component.UIComponent;
import dev.lrxh.mcui.elements.Element;
import dev.lrxh.mcui.elements.ElementSpace;
import dev.lrxh.mcui.elements.UIRender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HealthUIComponent extends UIComponent {

    private final Element full;
    private final Element half;
    private final Element empty;

    public HealthUIComponent() {
        full = register("https://i.imgur.com/tfqo2Pt.png", 27, 3);
        half = register("https://i.imgur.com/7UwHZoK.png", 27, 3);
        empty = register("https://i.imgur.com/fw0RByQ.png", 27, 3);

        full.setElementSpace(ElementSpace.BACKSPACE_2);
        half.setElementSpace(ElementSpace.BACKSPACE_2);
        empty.setElementSpace(ElementSpace.BACKSPACE_2);

        load();
    }

    @Override
    public void tick(Player player) {
        double hearts = Math.round(player.getHealth()) / 2.0;

        List<Element> bar = new ArrayList<>();
        bar.add(ElementSpace.FORWARDSPACE_48.createElement());
        bar.add(ElementSpace.FORWARDSPACE_2.createElement());

        for (int i = 0; i < 10; i++) {
            double heartIndex = 10 - i;

            if (hearts >= heartIndex) {
                bar.add(full);
            } else if (hearts >= heartIndex - 0.5) {
                bar.add(half);
            } else {
                bar.add(empty);
            }
        }

        UIRender.ACTION_BAR_RENDER.render(player, bar);
    }
}