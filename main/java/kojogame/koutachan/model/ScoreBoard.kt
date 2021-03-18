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
        player.scoreboard?.getObjective("${player.displayName}")?.unregister()
        val obj = player.scoreboard.registerNewObjective("${player.displayName}","dummy") //プレイヤーごとに作ったほうがいいって聞いた
        obj.setDisplaySlot(SIDEBAR)
        obj.setDisplayName("${ChatColor.YELLOW}KojoGame (${Bukkit.getOnlinePlayers().size})")
        obj.getScore("§m§l---------------------").setScore(10)
        player.sendMessage("DEBUG: TEST / $obj")
    }
}