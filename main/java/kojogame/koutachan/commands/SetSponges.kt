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
                if (args[0] == "iron") {
                    config.set("iron.world","${sender.world.name}")
                    config.set("iron.x","${sender.getTargetBlock(null,15).x}")
                    config.set("iron.y","${sender.getTargetBlock(null,15).y}")
                    config.set("iron.z","${sender.getTargetBlock(null,15).z}")
                    config.save(File)
                    sender.sendMessage("${ChatColor.WHITE}保存しました！")
                } else {
                    if (args[0] == "gold") {
                        config.set("gold.world","${sender.world.name}")
                        config.set("gold.x","${sender.getTargetBlock(null,15).x}")
                        config.set("gold.y","${sender.getTargetBlock(null,15).y}")
                        config.set("gold.z","${sender.getTargetBlock(null,15).z}")
                        config.save(File)
                        sender.sendMessage("${ChatColor.GOLD}保存しました！")
                    } else {
                        if (args[0] == "diamond") {
                            config.set("diamond.world","${sender.world.name}")
                            config.set("diamond.x","${sender.getTargetBlock(null,15).x}")
                            config.set("diamond.y","${sender.getTargetBlock(null,15).y}")
                            config.set("diamond.z","${sender.getTargetBlock(null,15).z}")
                            config.save(File)
                            sender.sendMessage("${ChatColor.AQUA}保存しました！")
                        } else {
                            sender.sendMessage("${ChatColor.RED}使い方: /setsponges [iron / gold / diamond]")
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