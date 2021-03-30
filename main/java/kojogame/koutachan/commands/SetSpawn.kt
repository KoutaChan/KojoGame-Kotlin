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
                if (args[0] == "red") {
                    config.set("Red.world", sender.world.name)
                    config.set("Red.x", sender.getLocation().x)
                    config.set("Red.y", sender.getLocation().y)
                    config.set("Red.z", sender.getLocation().z)
                    config.set("Red.yaw", sender.getLocation().yaw)
                    config.set("Red.pitch", sender.getLocation().pitch)
                    config.save(File)
                } else if (args[0] == "blue") {
                    config.set("Blue.world", sender.world.name)
                    config.set("Blue.x", sender.getLocation().x)
                    config.set("Blue.y", sender.getLocation().y)
                    config.set("Blue.z", sender.getLocation().z)
                    config.set("Blue.yaw", sender.getLocation().yaw)
                    config.set("Blue.pitch", sender.getLocation().pitch)
                    config.save(File)
                } else if (args[0] == "lobby") {
                    config.set("Lobby.world", sender.world.name)
                    config.set("Lobby.x", sender.getLocation().x)
                    config.set("Lobby.y", sender.getLocation().y)
                    config.set("Lobby.z", sender.getLocation().z)
                    config.set("Lobby.yaw", sender.getLocation().yaw)
                    config.set("Lobby.pitch", sender.getLocation().pitch)
                    config.save(File)
                    sender.sendMessage("テスト ${sender.getWorld()}")
                }
            }
        }
        return true
    }
}

