package kojogame.koutachan.commands

import kojogame.koutachan.KojoGame
import kojogame.koutachan.model.Timer
import kojogame.koutachan.util.GameState
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

object Start : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender is Player) {
            var Timer = 11
            if (GameState.GameState == 0) {
                GameState(1)
                object : BukkitRunnable() {
                    override fun run() {
                        if (0 < Timer) {
                            Timer--
                            if (Timer == 10) {
                                Bukkit.broadcastMessage("§aゲームは§l$Timer§a秒後に開始されます！")
                            } else {
                                Bukkit.broadcastMessage("§lゲームは開始されました！")
                                GameState(2)
                                Timer(600)
                                cancel()
                            }
                        }
                    }
                }.runTaskTimer(KojoGame.plugin, 0, 20)
            }
        }
    return true
    }
}
