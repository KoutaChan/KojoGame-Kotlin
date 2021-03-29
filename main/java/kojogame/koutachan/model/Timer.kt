package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.util.GameState.Companion.GameState
import org.bukkit.scheduler.BukkitRunnable

fun Timer(timer: Int) {
    var Timer = timer
    object : BukkitRunnable() {
        override fun run() {
            if (1 < Timer) {
                Timer--
                kojogame.koutachan.util.Timer(Timer)
                if (GameState != 2) {
                    cancel()
                }
            } else {
                cancel()
                RedWin()
            }
        }
    }.runTaskTimer(plugin, 0, 20)
}