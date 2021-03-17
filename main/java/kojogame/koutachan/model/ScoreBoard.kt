package kojogame.koutachan.model

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scoreboard.DisplaySlot.SIDEBAR

object ScoreBoard : Listener {

    @EventHandler(priority = EventPriority.HIGH)
    fun playedJoinEvent(e: PlayerJoinEvent) {
        scoreboard(e.player)
        e.player.sendMessage("DEBUG: ????????????????")
        e.player.sendMessage("テストだよ")
    }


    fun scoreboard(player: Player) {
        Bukkit.getScoreboardManager().newScoreboard.registerNewObjective("kojogame", "dummy")
        val obj = Bukkit.getScoreboardManager().newScoreboard.registerNewObjective("kojogame", "dummy")
        obj.setDisplaySlot(SIDEBAR)
        val sidebar10 = obj.getScore("Kouta1212")
        sidebar10.setScore(10)
        //Bukkit.getScoreboardManager().newScoreboard.getObjective("kojogame").setDisplayName("${ChatColor.YELLOW}+攻城戦")
        //Bukkit.getScoreboardManager().newScoreboard.getObjective("kojogame").getScore("=================").setScore(10)
        //obj.setDisplayName("${ChatColor.YELLOW}+攻城戦")//(${Bukkit.getOnlinePlayers().size})
        player.sendMessage("DEBUG: TEST / $obj")
    }
}