package me.pikamug.quests.tasks;

import me.pikamug.quests.player.Quester;
import me.pikamug.quests.quests.Quest;
import me.pikamug.quests.util.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class TitleRepeater extends BukkitRunnable {
    private final Player p;
    private final Title title;
    private final Quest quest;
    private final Quester quester;
    
    public TitleRepeater(Player p, Title title, Quest quest, Quester quester) {
        this.p = p;
        this.title = title;
        this.quest = quest;
        this.quester = quester;
    }

    @Override
    public void run() {
        if (!p.isOnline() || !quester.getCurrentQuests().containsKey((Quest) quest))
            cancel();

        p.sendTitle(colorize(title.getTitle()), colorize(title.getSubtitle()), 0, 10 * 20, 0);
    }

    public static BukkitTask startTask(@NotNull Plugin plugin, @NotNull Player p, @NotNull Quest quest, Quester quester) {
        Title title = quest.getTitle();
        TitleRepeater task = new TitleRepeater(p, title, quest, quester);
        if (quest.getTitle().getDuration() == -1)
            return task.runTaskTimerAsynchronously(plugin, 0, 10 * 20L);
        else return Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> p.sendTitle(title.getTitle(), title.getSubtitle()
                , title.getFadeIn() * 20, title.getDuration() * 20, title.getFadeOut() * 20));
    }

    private static String colorize(String origin) {
        return ChatColor.translateAlternateColorCodes('&', origin);
    }
}
