package kojogame.koutachan.model



import kojogame.koutachan.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.Listener
import org.bukkit.scoreboard.DisplaySlot
import java.time.LocalDateTime


object scoreboard : Listener {

    fun ScoreBoardUpdate() {
        Bukkit.getScheduler().runTaskTimer(plugin, Runnable {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")?.unregister()
            Bukkit.getScoreboardManager().mainScoreboard.registerNewObjective("KojoGame", "dummy")
            val obj = Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")
            obj.setDisplaySlot(DisplaySlot.SIDEBAR)
            val time = LocalDateTime.now()
            obj.setDisplayName("${ChatColor.YELLOW}[ Kojo Game (${Bukkit.getOnlinePlayers().size}) ]")
            obj.getScore("§r§e§m------------------------------").setScore(10)
            obj.getScore("§b現在時刻(Y/M/D):${time.year}/${time.month.value}/${time.dayOfMonth} ${time.hour}:${time.minute}:${time.second}").setScore(9)
            obj.getScore("§e§m------------------------------").setScore(0)
        }, 0, 20)
    }
}
