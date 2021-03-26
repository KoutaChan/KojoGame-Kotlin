package kojogame.koutachan.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

object SetSpawn : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {
            if (args?.isNotEmpty()!!) {
                val File = File("plugins/KojoGame/config.yml")
                val config = YamlConfiguration.loadConfiguration(File)
                val X = sender.getLocation().x
                val Y = sender.getLocation().y
                val Z = sender.getLocation().z
                if (args[0] == "red") {
                    config.set("RedSpawn", listOf(X, Y, Z))
                    config.save(File)
                    sender.sendMessage("§cR:§f $X , $Y , $Z")
                } else if (args[0] == "blue") {
                    config.set("BlueSpawn", listOf(X, Y, Z))
                    config.save(File)
                    sender.sendMessage("§9B:§f $X , $Y , $Z")
                }
            }
        }
        return true
    }
}

