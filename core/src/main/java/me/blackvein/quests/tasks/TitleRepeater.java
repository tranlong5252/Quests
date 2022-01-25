package me.blackvein.quests.tasks;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.blackvein.quests.util.Title;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TitleRepeater extends BukkitRunnable {

    private final Player p;
    private final Title title;

    @Override
    public void run() {
        if (!p.isOnline())
            cancel();

        p.sendTitle(title.getTitle(), title.getSubtitle(), 0, 10 * 20, 0);
    }

    public static BukkitTask startTask(@NonNull Plugin plugin,  @NonNull Player p, @NonNull Title title) {
        TitleRepeater task = new TitleRepeater(p, title);
        if (title.getDuration() == -1)
            return task.runTaskTimerAsynchronously(plugin, 0, 10 * 20L);
        else return task.runTaskAsynchronously(plugin);
    }

}
