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
        full = register("full.png", 27, 2);
        half = register("half.png", 27, 2);
        empty = register("empty.png", 27, 2);

        full.setElementSpace(ElementSpace.BACKSPACE_2);
        half.setElementSpace(ElementSpace.BACKSPACE_2);
        empty.setElementSpace(ElementSpace.BACKSPACE_2);

        load();
    }

    @Override
    public void tick(Player player) {
        double hearts = player.getHealth() / 2;
        Element[] bar = new Element[11];
        bar[0] = ElementSpace.BACKSPACE_48.createElement();

        for (int i = 1; i <= 10; i++) {
            if (hearts >= i) {
                bar[i] = full;
            } else if (hearts >= i - 0.5) {
                bar[i] = half;
            } else {
                bar[i] = empty;
            }
        }

        DefaultUIRender.ACTION_BAR.render(player, bar);

    }
}
