package kojogame.koutachan

import kojogame.koutachan.commands.*
import kojogame.koutachan.event.ResetSponges
import kojogame.koutachan.event.SpongeParticle
import kojogame.koutachan.event.event
import kojogame.koutachan.model.scoreboard.ScoreBoardUpdate
import org.bukkit.plugin.java.JavaPlugin

var State = kojogame.koutachan.util.GameState.LOBBY
var Timer = 0

class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }
    override fun onEnable() {
        // Plugin startup logic
        plugin = this
        saveDefaultConfig()
        ScoreBoardUpdate()
        SpongeParticle()
        ResetSponges()
        getCommand("debug").executor = debug
        getCommand("setsponges").executor = cmdSponges
        getCommand("setspawn").executor = SetSpawn
        getCommand("start").executor = Start
        getCommand("gm").executor = SimpleGameMode
        server.pluginManager.registerEvents(event, this)
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}