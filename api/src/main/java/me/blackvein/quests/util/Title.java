package me.blackvein.quests.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Title {

    private final String title, subtitle;
    private final int fadeIn, fadeOut, duration;

    public String toPlainText() {
        return title + "<n>" + subtitle + ";" + duration + ";" + fadeIn + ";" + fadeOut;
    }

    public static Title fromPlainText(String input) {
        String[] split = input.split(";");
        Title.TitleBuilder builder = Title.builder();

        if (split.length < 2)
            return null;

        String[] fullTitle = split[0].split("<n>");
        builder.title(fullTitle[0]);
        if (fullTitle.length > 1)
            builder.subtitle(fullTitle[1]);

        try {
            int duration = Integer.parseInt(split[1]);
            builder.duration(duration);

            if (split.length > 2) {
                int fadeIn = Integer.parseInt(split[2]);
                builder.fadeIn(fadeIn);
            }

            if (split.length > 3) {
                int fadeOut = Integer.parseInt(split[3]);
                builder.fadeOut(fadeOut);
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return builder.build();
    }

}
