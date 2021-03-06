package kojogame.koutachan.model



import kojogame.koutachan.DiamondState
import kojogame.koutachan.GoldState
import kojogame.koutachan.IronState
import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.State
import kojogame.koutachan.util.GameState
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.Listener
import org.bukkit.scoreboard.DisplaySlot
import java.time.LocalDateTime


object scoreboard : Listener {

    fun ScoreBoardUpdate() { //多分プレイヤーごとにスコアボードは使わないから1個だけの対応でOK
        Bukkit.getScheduler().runTaskTimer(plugin, Runnable {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")?.unregister()
            Bukkit.getScoreboardManager().mainScoreboard.registerNewObjective("KojoGame", "dummy")
            val obj = Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame")
            val time = LocalDateTime.now()
            obj.setDisplaySlot(DisplaySlot.SIDEBAR)
            obj.setDisplayName("${ChatColor.YELLOW}[ Kojo Game (${Bukkit.getOnlinePlayers().size}) ]")
            obj.getScore("§7${time.year}/${time.month.value}/${time.dayOfMonth} §80.3β").setScore(10) //${time.hour}:${time.minute}:${time.second}
            obj.getScore("").setScore(9)
            obj.getScore("${ChatColor.BOLD}").setScore(7)
            obj.getScore("${ChatColor.RESET}").setScore(3)
            obj.getScore(" §c赤チーム ➤ 未実装").setScore(2)
            obj.getScore(" §9青チーム ➤ 未実装").setScore(1)
            obj.getScore("${ChatColor.UNDERLINE}").setScore(0)
            GameStateUpdate() //Line 8
            IronUpdate() //Line 6
            GoldUpdate() //Line 5
            DiamondUpdate() //Line 4
    }, 0, 10) //多分20だと秒数が表示されないので
    }
    fun GameStateUpdate() {
        if (State == GameState.LOBBY) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" » ゲーム待機中").setScore(8)
        } else if (State == GameState.STARTING) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" » ゲーム開始中").setScore(8)
        } else if (State == GameState.PLAYING) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" 残り時間 » ${kojogame.koutachan.Timer}秒").setScore(8)
        } else if (State == GameState.ENDING) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" » ゲーム終了").setScore(8)
        }
    }
    fun IronUpdate() {
        if (IronState == true) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" スポンジ(1) » §c破壊されています").setScore(6)
        } else if (IronState == false) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" スポンジ(1) » §a破壊されていません").setScore(6)
        }
    }
    fun GoldUpdate() {
        if (GoldState == true) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" §6スポンジ(2) » §c破壊されています").setScore(5)
        } else if (GoldState == false) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" §6スポンジ(2) » §a破壊されていません").setScore(5)
        }
    }
    fun DiamondUpdate() {
        if (DiamondState == true) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" §bスポンジ(3) » §c破壊されています").setScore(4)
        } else if (DiamondState == false) {
            Bukkit.getScoreboardManager().mainScoreboard.getObjective("KojoGame").getScore(" §bスポンジ(3) » §a破壊されていません").setScore(4)
        }
    }
}