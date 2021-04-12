package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.State
import kojogame.koutachan.Timer
import kojogame.koutachan.util.GameState
import org.bukkit.scheduler.BukkitRunnable

fun Timer(timer: Int) {
    Timer = timer
    object : BukkitRunnable() {
        override fun run() {
            if (1 < Timer) {
                Timer--
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