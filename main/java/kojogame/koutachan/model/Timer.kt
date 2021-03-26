package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import org.bukkit.scheduler.BukkitRunnable

fun Timer(timer: Int) {
    var Timer = timer
    object : BukkitRunnable() {
        override fun run() {
            if (0 < Timer) {
                Timer--
                kojogame.koutachan.util.Timer(Timer)
            } else {
                cancel()
                RedWin()
            }
        }
    }.runTaskTimer(plugin, 0, 20)
}