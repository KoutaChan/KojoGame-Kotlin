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
                object : BukkitRunnable() {
                    override fun run() {
                        if (0 < Timer) {
                            Timer--
                            if (Timer == 10) {
                                GameState(1)
                                Bukkit.broadcastMessage("§aゲームは10秒後に開始されます！")
                            } else if (Timer == 9) {
                                Bukkit.broadcastMessage("§aゲームは9秒後に開始されます！")
                            } else if (Timer == 8) {
                                Bukkit.broadcastMessage("§aゲームは8秒後に開始されます！")
                            } else if (Timer == 7) {
                                Bukkit.broadcastMessage("§aゲームは7秒後に開始されます！")
                            } else if (Timer == 6) {
                                Bukkit.broadcastMessage("§eゲームは6秒後に開始されます！")
                            } else if (Timer == 5) {
                                Bukkit.broadcastMessage("§eゲームは5秒後に開始されます！")
                            } else if (Timer == 4) {
                                Bukkit.broadcastMessage("§eゲームは4秒後に開始されます！")
                            } else if (Timer == 3) {
                                Bukkit.broadcastMessage("§cゲームは3秒後に開始されます！")
                            } else if (Timer == 2) {
                                Bukkit.broadcastMessage("§cゲームは2秒後に開始されます！")
                            } else if (Timer == 1) {
                                Bukkit.broadcastMessage("§cゲームは1秒後に開始されます！")
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
