package kojogame.koutachan.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

var test = false


    object debug : CommandExecutor {
        override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
            sender?.sendMessage("$test")
            test = true
            return true
        }
    }
