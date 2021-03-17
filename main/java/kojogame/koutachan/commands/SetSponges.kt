package kojogame.koutachan.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

object cmdSponges : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {
            if (args?.isNotEmpty()!!) {
                val File = File("plugins/KojoGame/config.yml")
                val config = YamlConfiguration.loadConfiguration(File)
                val TargetBlockX = sender.getTargetBlock(null,5).getLocation().blockX //valで保存しなくてもいいのだが、見にくくなるためvalで保存
                val TargetBlockY = sender.getTargetBlock(null,5).getLocation().blockY
                val TargetBlockZ = sender.getTargetBlock(null,5).getLocation().blockZ
                if (args[0] == "iron") {
                    config.set("iron",listOf(TargetBlockX,TargetBlockY,TargetBlockZ))
                    config.save(File)
                    sender.sendMessage("${ChatColor.WHITE}保存しました！ \nX:$TargetBlockX \nY:$TargetBlockY \nZ:$TargetBlockZ")
                } else {
                    if (args[0] == "gold") {
                        config.set("gold",listOf(TargetBlockX,TargetBlockY,TargetBlockZ))
                        config.save(File)
                        sender.sendMessage("${ChatColor.GOLD}保存しました！ \nX:$TargetBlockX \nY:$TargetBlockY \nZ:$TargetBlockZ")
                    } else {
                        if (args[0] == "diamond") {
                            config.set("diamond",listOf(TargetBlockX,TargetBlockY,TargetBlockZ))
                            config.save(File)
                            sender.sendMessage("${ChatColor.AQUA}保存しました！ \nX:$TargetBlockX \nY:$TargetBlockY \nZ:$TargetBlockZ ${config.getString("iron")})")
                        } else {
                            sender.sendMessage("${ChatColor.RED}使い方: /setsponges [iron / gold / diamond] \n§bdebug: {$args[0]}")
                        }
                    }
                }
            } else {
                sender.sendMessage("${ChatColor.RED}使い方: /setsponges [iron / gold / diamond]")
            }
        } else {
            sender?.sendMessage("${ChatColor.RED}You can't execute this command from console!")
        }
        return true
    }
}