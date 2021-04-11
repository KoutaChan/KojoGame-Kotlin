package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.State
import kojogame.koutachan.util.GameState
import org.bukkit.scheduler.BukkitRunnable

fun Timer(timer: Int) {
    var Timer = timer
    object : BukkitRunnable() {
        override fun run() {
            if (1 < Timer) {
                Timer--
                kojogame.koutachan.util.Timer(Timer)
                if (State != GameState.PLAYING) {
                    cancel()
                }
            } else {
                cancel()
                RedWin()
            }
        }
    }.runTaskTimer(plugin, 0, 20)
}