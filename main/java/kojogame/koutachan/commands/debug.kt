package kojogame.koutachan.commands

import kojogame.koutachan.event.SpongeParticle
import kojogame.koutachan.model.BlueWin
import kojogame.koutachan.model.RedWin
import kojogame.koutachan.model.Timer
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
            } else if (args[0] == "1") {
                GameState(0)
                sender?.sendMessage(":ok_hand:")
            } else if (args[0] == "2") {
                GameState(1)
                sender?.sendMessage(":ok_hand:")
            } else if (args[0] == "3") {
                GameState(2)
                sender?.sendMessage(":ok_hand:")
            } else if (args[0] == "4") {
                GameState(3)
                sender?.sendMessage(":ok_hand:")
            } else if (args[0] == "5") {
                BlueWin()
            } else if (args[0] == "6") {
                RedWin()
            } else if (args[0] == "7") {
                Timer(60)
            } else if (args[0] == "8") {
                SpongeParticle()
            }
        }
        return true
    }
}