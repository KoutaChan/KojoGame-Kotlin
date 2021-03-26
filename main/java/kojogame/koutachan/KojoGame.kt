package kojogame.koutachan

import kojogame.koutachan.commands.*
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
        getCommand("debug").executor = debug
        getCommand("setsponges").executor = cmdSponges
        getCommand("setspawn").executor = SetSpawn
        getCommand("start").executor = Start
        getCommand("gm").executor = SimpleGameMode
        server.pluginManager.registerEvents(event, this)
        scoreboard.ScoreBoardUpdate()
        saveDefaultConfig()
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}