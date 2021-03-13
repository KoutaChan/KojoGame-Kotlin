package kojogame.koutachan.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

object cmdSponges : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {
            if (args?.isNotEmpty()!!) {
                val sponge = args[0]
                if (sponge == "iron") {
                    val ironTargetBlock = sender.getTargetBlock(null, 100)
                    val ironX = ironTargetBlock.getLocation().blockX
                    val ironY = ironTargetBlock.getLocation().blockY
                    val ironZ = ironTargetBlock.getLocation().blockZ
                    sender.sendMessage("Data: $ironTargetBlock\n$ironX $ironY $ironZ")
                } else {
                    if (sponge == "gold") {
                        val goldTargetBlock = sender.getTargetBlock(null, 100)
                        val goldX = goldTargetBlock.getLocation().blockX
                        val goldY = goldTargetBlock.getLocation().blockY
                        val goldZ = goldTargetBlock.getLocation().blockZ
                        sender.sendMessage("Data: $goldTargetBlock\n$goldX $goldY $goldZ")
                    } else {
                        if (sponge == "diamond") {
                            val diamondTargetBlock = sender.getTargetBlock(null, 100)
                            val diamondX = diamondTargetBlock.getLocation().blockX
                            val diamondY = diamondTargetBlock.getLocation().blockY
                            val diamondZ = diamondTargetBlock.getLocation().blockZ
                            sender.sendMessage("Data: $diamondTargetBlock\n$diamondX $diamondY $diamondZ")
                        } else {
                            sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond] \n§b結果(result): (arg0: $sponge)")
                        }
                    }
                }
            } else {
                sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond]")
            }
        } else {
            sender?.sendMessage("§cYou can't execute this command from console!")
        }
        return true
    }
}