package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GameState
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getOnlinePlayers
import org.bukkit.Location
import org.bukkit.Sound


fun BlueWin() {
    for (p in Bukkit.getOnlinePlayers())
        p.sendTitle("§9青チームの勝利","§7スポンジが破壊されたため勝利")
    IronSponges(false)
    GoldSponges(false)
    DiamondSponges(false)
    GameState(3)
    EndTimer()
}
fun RedWin() {
    for(p in Bukkit.getOnlinePlayers())
        p.sendTitle("§c赤チームの勝利","§7時間切れのため勝利")
    for(p in Bukkit.getOnlinePlayers())
        p.playSound(p.location, Sound.ENTITY_WITHER_SPAWN,20F,1F)
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
        var location = Location(
            Bukkit.getWorld("world"),
            1.0,
            2.0,
            3.0
        )
        Bukkit.broadcastMessage("$location")
        for(p in getOnlinePlayers())
            p.teleport(location)
        GameState(0)
    }, 20 * 10)
}