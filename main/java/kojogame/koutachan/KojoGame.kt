package kojogame.koutachan

import kojogame.koutachan.commands.SimpleGameMode
import kojogame.koutachan.commands.cmdSponges
import kojogame.koutachan.event.event
import kojogame.koutachan.model.scoreboard
import org.bukkit.plugin.java.JavaPlugin

class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }
    override fun onEnable() {
        // Plugin startup logic
        plugin = this
        getCommand("setsponges").executor = cmdSponges
        getCommand("gm").executor = SimpleGameMode
        server.pluginManager.registerEvents(event, this)
        server.pluginManager.registerEvents(scoreboard, this)
        saveDefaultConfig()

    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}