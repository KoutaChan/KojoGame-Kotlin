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
            val time = LocalDateTime.now()
            obj.setDisplaySlot(DisplaySlot.SIDEBAR)
            obj.setDisplayName("${ChatColor.YELLOW}[ Kojo Game (${Bukkit.getOnlinePlayers().size}) ]")
            obj.getScore("§7${time.year}/${time.month.value}/${time.dayOfMonth} §8EventServer").setScore(10) //${time.hour}:${time.minute}:${time.second}
            obj.getScore("").setScore(9)
            if (kojogame.koutachan.util.GameState.GameState == 0) {
                obj.getScore(" » ゲーム待機中").setScore(8)
            }else if (kojogame.koutachan.util.GameState.GameState == 1) {
                obj.getScore(" » ゲーム開始中").setScore(8)
            }else if (kojogame.koutachan.util.GameState.GameState == 2) {
                obj.getScore(" » ゲーム中").setScore(8)
            }else if (kojogame.koutachan.util.GameState.GameState == 3) {
                obj.getScore(" » ゲーム終了").setScore(8)
        }
    }, 0, 20)
    }
}