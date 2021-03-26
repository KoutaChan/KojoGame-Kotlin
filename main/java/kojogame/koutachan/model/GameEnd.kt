package kojogame.koutachan.model

import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File


fun BlueWin() {
    for (p in Bukkit.getOnlinePlayers())
        p.sendTitle("§9青チームの勝利","§7スポンジが破壊されたため勝利")
    val File = File("plugins/KojoGame/config.yml")
    val config = YamlConfiguration.loadConfiguration(File)
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