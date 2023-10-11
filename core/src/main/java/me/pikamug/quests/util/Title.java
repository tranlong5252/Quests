package me.blackvein.quests.util;
public class Title {
    private final String title, subtitle;
    private final int fadeIn, fadeOut, duration;

    public Title(String title, String subtitle, int fadeIn, int fadeOut, int duration) {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.fadeOut = fadeOut;
        this.duration = duration;
    }

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

    public static TitleBuilder builder() {
        return new TitleBuilder();
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getFadeIn() {
        return fadeIn;
    }

    public int getFadeOut() {
        return fadeOut;
    }

    public int getDuration() {
        return duration;
    }

    public static class TitleBuilder {
        private String title, subtitle;
        private int fadeIn, fadeOut, duration;

        public TitleBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TitleBuilder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public TitleBuilder fadeIn(int fadeIn) {
            this.fadeIn = fadeIn;
            return this;
        }

        public TitleBuilder fadeOut(int fadeOut) {
            this.fadeOut = fadeOut;
            return this;
        }

        public TitleBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Title build() {
            return new Title(title, subtitle, fadeIn, fadeOut, duration);
        }
    }

}
