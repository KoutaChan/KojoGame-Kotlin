package kojogame.koutachan.model


import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.server.PluginEnableEvent
import org.bukkit.scoreboard.DisplaySlot.SIDEBAR



object scoreboard : Listener{

    @EventHandler
    fun scoreboard(event: PluginEnableEvent) {
        Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")?.unregister()
        val obj = Bukkit.getScoreboardManager().mainScoreboard.registerNewObjective("KojoGame","dummy")
        obj.setDisplaySlot(SIDEBAR)
        obj.setDisplayName("${ChatColor.YELLOW}KojoGame (${Bukkit.getOnlinePlayers().size})")
        obj.getScore("§m§l---------------------").setScore(10)
    }
}