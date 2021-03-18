package kojogame.koutachan

import kojogame.koutachan.commands.cmdSponges
import kojogame.koutachan.event.event
import kojogame.koutachan.model.scoreboard
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class KojoGame : JavaPlugin(),Listener {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("setsponges").executor = cmdSponges
        server.pluginManager.registerEvents(event,this)
        server.pluginManager.registerEvents(scoreboard,this)
        saveDefaultConfig()
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}
