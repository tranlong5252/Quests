package me.blackvein.quests.tasks;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.blackvein.quests.player.IQuester;
import me.blackvein.quests.quests.IQuest;
import me.blackvein.quests.util.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TitleRepeater extends BukkitRunnable {

    private final Player p;
    private final Title title;
    private final IQuest quest;
    private final IQuester quester;

    @Override
    public void run() {
        if (!p.isOnline() || !quester.getCurrentQuests().containsKey(quest))
            cancel();

        p.sendTitle(colorize(title.getTitle()), colorize(title.getSubtitle()), 0, 10 * 20, 0);
    }

    public static BukkitTask startTask(@NonNull Plugin plugin, @NonNull Player p, @NonNull IQuest quest, IQuester quester) {
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
