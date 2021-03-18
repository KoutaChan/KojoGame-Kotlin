package kojogame.koutachan.model



import kojogame.koutachan.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginEnableEvent
import org.bukkit.scoreboard.DisplaySlot


object scoreboard : Listener {


    @EventHandler
    fun scoreboard(event: PluginEnableEvent) {
        Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")?.unregister()
        Bukkit.getScoreboardManager().mainScoreboard.registerNewObjective("KojoGame", "dummy")
        Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").setDisplaySlot(DisplaySlot.SIDEBAR)
        ScoreBoardUpdate()
    }
}

fun ScoreBoardUpdate() {
    Bukkit.getScheduler().runTaskTimer(plugin, Runnable {
        val obj = Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")
        obj.setDisplayName("${ChatColor.YELLOW}[ Kojo Game (${Bukkit.getOnlinePlayers().size}) ]")
        obj.getScore("§e§m------------------------------").setScore(10) //25
    },0, 20)
}
