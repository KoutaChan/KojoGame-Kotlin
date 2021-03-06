package kojogame.koutachan.commands

import kojogame.koutachan.KojoGame
import kojogame.koutachan.State
import kojogame.koutachan.model.Timer
import kojogame.koutachan.util.GameState
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
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
            if (State == GameState.LOBBY) {
                State = GameState.STARTING
                object : BukkitRunnable() {
                    override fun run() {
                        if (1 < Timer) {
                            Timer--
                            Bukkit.broadcastMessage("§aゲームは§l$Timer§a秒後に開始されます・・・")
                            if (6 > Timer) {
                                for(p in Bukkit.getOnlinePlayers())
                                    p.sendTitle("${ChatColor.RED}$Timer","")
                                for(p in Bukkit.getOnlinePlayers())
                                    p.playSound(p.getLocation(),Sound.BLOCK_NOTE_HAT,100F,1F)
                            }
                        } else {
                            Bukkit.broadcastMessage("§lゲームは開始されました！")
                            for(p in Bukkit.getOnlinePlayers())
                                p.playSound(p.location, Sound.ENTITY_WITHER_SPAWN,20F,1F)
                            State = GameState.PLAYING
                            Timer(600)
                            cancel()
                        }
                    }
                }.runTaskTimer(KojoGame.plugin, 0, 20)
            }
        }
    return true
    }
}
