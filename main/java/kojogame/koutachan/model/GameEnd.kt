package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GameState
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getOnlinePlayers
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File


fun BlueWin() {
    for (p in getOnlinePlayers())
        p.sendTitle("§9青チームの勝利","§7スポンジが破壊されたため勝利")
    IronSponges(false)
    GoldSponges(false)
    DiamondSponges(false)
    GameState(3)
    EndTimer()
}
fun RedWin() {
    for(p in getOnlinePlayers())
        p.sendTitle("§c赤チームの勝利","§7時間切れのため勝利")
    IronSponges(false)
    GoldSponges(false)
    DiamondSponges(false)
    GameState(3)
    EndTimer()
}
fun BlueWinChecker() {
    if (IronSponges.IronSponges == true) {
        if (GoldSponges.GoldSponges == true) {
            if (DiamondSponges.DiamondSponges == true) {
                BlueWin()
            }
        }
    }
}
fun EndTimer() {
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
        for(p in getOnlinePlayers())
            p.teleport(location)
        GameState(0)
    }, 20 * 10)
}
