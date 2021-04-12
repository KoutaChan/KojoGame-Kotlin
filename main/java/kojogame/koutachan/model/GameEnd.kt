package kojogame.koutachan.model

import kojogame.koutachan.DiamondState
import kojogame.koutachan.GoldState
import kojogame.koutachan.IronState
import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.State
import kojogame.koutachan.event.ResetSponges
import kojogame.koutachan.util.GameState
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getOnlinePlayers
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File


fun BlueWin() {
    for (p in getOnlinePlayers())
        p.sendTitle("§9青チームの勝利","§7スポンジが破壊されたため勝利")
    EndTimer()
}
fun RedWin() {
    for(p in getOnlinePlayers())
        p.sendTitle("§c赤チームの勝利","§7時間切れのため勝利")
    EndTimer()
}
fun BlueWinChecker() {
    if (IronState == true) {
        if (GoldState == true) {
            if (DiamondState == true) {
                BlueWin()
            }
        }
    }
}
fun EndTimer() {
    State = GameState.ENDING
    Bukkit.broadcastMessage("§e10秒後にロビーに戻ります")
    Bukkit.getScheduler().runTaskLater(plugin, Runnable {
        Bukkit.broadcastMessage("§7ロビーにテレポートしています...")
        val File = File("plugins/KojoGame/config.yml")
        val config = YamlConfiguration.loadConfiguration(File)
        var location = Location(
            Bukkit.getWorld("${config.get("Lobby.world")}"),
            config.getDouble("Lobby.x"),
            config.getDouble("Lobby.y"),
            config.getDouble("Lobby.z"),
            config.getDouble("Lobby.yaw").toFloat(),
            config.getDouble("Lobby.pitch").toFloat())
        IronState = false
        GoldState = false
        DiamondState = false
        for(p in getOnlinePlayers())
            p.teleport(location)
        ResetSponges()
        State = GameState.LOBBY
    }, 20 * 10)
}
