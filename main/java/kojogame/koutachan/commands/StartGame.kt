package kojogame.koutachan.commands

import kojogame.koutachan.KojoGame
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object StartGame : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender is Player) {
            if (args?.isNotEmpty()!!) {
            }
        }
        return true
    }
}