package dev.lrxh.mcuiexample;

import dev.lrxh.mcui.component.UIComponent;
import dev.lrxh.mcui.elements.DefaultUIRender;
import dev.lrxh.mcui.elements.Element;
import dev.lrxh.mcui.elements.ElementSpace;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.stream.Stream;

public class HealthUIComponent extends UIComponent {

    private final Element full;
    private final Element half;
    private final Element empty;

    public HealthUIComponent() {
        full = register("full.png", 27, 2);
        half = register("half.png", 27, 2);
        empty = register("empty.png", 27, 2);
        load();
    }

    @Override
    public void tick(Player player) {
        double stamina = player.getHealth() / 2;
        Element[] bar = new Element[10];

        for (int i = 0; i < 10; i++) {
            if (stamina >= i + 1) {
                bar[i] = full;
            } else if (stamina >= i + 0.5) {
                bar[i] = half;
            } else {
                bar[i] = empty;
            }
        }

        DefaultUIRender.ACTION_BAR.render(player, Stream.concat(
                Stream.of(ElementSpace.BACKSPACE_48.createElement()),
                Arrays.stream(bar)
        ).toArray(Element[]::new));

    }
}
