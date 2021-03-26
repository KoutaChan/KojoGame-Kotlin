package kojogame.koutachan.model

import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit


fun BlueWin() {
    for (p in Bukkit.getOnlinePlayers())
        p.sendTitle("§9青チームの勝利","§7スポンジが破壊されたため勝利")
    IronSponges(false)
    GoldSponges(false)
    DiamondSponges(false)
}
fun RedWin() {
    for(p in Bukkit.getOnlinePlayers())
        p.sendTitle("§c赤チームの勝利","§7時間切れのため勝利")
    IronSponges(false)
    GoldSponges(false)
    DiamondSponges(false)
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