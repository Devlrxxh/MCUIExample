package dev.lrxh.mcuiexample;

import dev.lrxh.mcui.component.UIComponent;
import dev.lrxh.mcui.elements.DefaultUIRender;
import dev.lrxh.mcui.elements.Element;
import dev.lrxh.mcui.elements.ElementSpace;
import org.bukkit.entity.Player;

public class HealthUIComponent extends UIComponent {

    private final Element full;
    private final Element half;
    private final Element empty;

    public HealthUIComponent() {
        full = register("https://i.imgur.com/tfqo2Pt.png", 27, 3);
        half = register("https://i.imgur.com/7UwHZoK.png", 27, 3);
        empty = register("https://i.imgur.com/fw0RByQ.png", 27, 3);

        full.setElementSpace(ElementSpace.BACKSPACE_1);
        half.setElementSpace(ElementSpace.BACKSPACE_1);
        empty.setElementSpace(ElementSpace.BACKSPACE_1);

        load();
    }

    @Override
    public void tick(Player player) {
        double hearts = player.getHealth() / 2;
        Element[] bar = new Element[12];
        bar[0] = ElementSpace.FORWARDSPACE_48.createElement();
        bar[1] = ElementSpace.FORWARDSPACE_1.createElement();

        for (int i = 0; i < 9; i++) {
            int barIndex = 10 - i;
            double heartIndex = i + 1;

            if (hearts >= heartIndex) {
                bar[barIndex] = full;
            } else if (hearts >= heartIndex - 0.5) {
                bar[barIndex] = half;
            } else {
                bar[barIndex] = empty;
            }
        }

        DefaultUIRender.ACTION_BAR.render(player, bar);
    }

}