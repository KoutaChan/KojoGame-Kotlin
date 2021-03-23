package kojogame.koutachan.commands

import kojogame.koutachan.util.GameState
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object debug : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (args?.isNotEmpty()!!) {
            if (args[0] == "0") {
                sender?.sendMessage("${GameState.GameState}")
                return true
            }else if (args[0] == "1") {
                GameState(1)
                sender?.sendMessage(":ok_hand:")
            }
        }
    return true
    }
}