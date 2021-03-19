package kojogame.koutachan.commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SimpleGameMode : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {
            if (args?.isNotEmpty()!!) {
                if (args[0] == "0") {
                    sender.setGameMode(GameMode.SURVIVAL)
                }else if (args[0] == "1") {
                    sender.setGameMode(GameMode.CREATIVE)
                }else if (args[0] == "2") {
                    sender.setGameMode(GameMode.ADVENTURE)
                }else if (args[0] == "3") {
                    sender.setGameMode(GameMode.SPECTATOR)
                }else sender.sendMessage("§c使い方が間違っています！ /gm [0 / 1 / 2 / 3]")
            }else sender.sendMessage("§c使い方が間違っています！ /gm [0 / 1 / 2 / 3]")
        }else sender?.sendMessage("${ChatColor.RED}You can't execute this command from console!")
    return true
    }
}