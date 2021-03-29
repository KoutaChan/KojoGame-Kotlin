package kojogame.koutachan.event

import kojogame.koutachan.model.BlueWinChecker
import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.block.BlockBreakEvent
import java.io.File

fun iron(e: BlockBreakEvent) {
    val File = File("plugins/KojoGame/config.yml")
    val config = YamlConfiguration.loadConfiguration(event.File)
    if (e.block.world.name == config.getString("iron.world")) {
        if ("${e.block.x}" == config.get("iron.x")) {
            if ("${e.block.y}" == config.get("iron.y")) {
                if ("${e.block.z}" == config.get("iron.z")) {
                    Bukkit.broadcastMessage("§f鉄のスポンジが破壊されました")
                    IronSponges(true)
                    BlueWinChecker()
                    e.block.setType(Material.BEDROCK)
                }else e.isCancelled = true
            }else e.isCancelled = true
        }else e.isCancelled = true
    }else e.isCancelled = true
}

fun gold(e: BlockBreakEvent) {
    val File = File("plugins/KojoGame/config.yml")
    val config = YamlConfiguration.loadConfiguration(event.File)
    if (e.block.world.name == config.getString("gold.world")) {
        if ("${e.block.x}" == config.get("gold.x")) {
            if ("${e.block.y}" == config.get("gold.y")) {
                if ("${e.block.z}" == config.get("gold.z")) {
                    Bukkit.broadcastMessage("§6金のスポンジが破壊されました")
                    GoldSponges(true)
                    BlueWinChecker()
                    e.block.setType(Material.BEDROCK)
                }else e.isCancelled = true
            }else e.isCancelled = true
        }else e.isCancelled = true
    }else e.isCancelled = true
}

fun diamond(e: BlockBreakEvent) {
    val File = File("plugins/KojoGame/config.yml")
    val config = YamlConfiguration.loadConfiguration(event.File)
    if (e.block.world.name == config.getString("diamond.world")) {
        if ("${e.block.x}" == config.get("diamond.x")) {
            if ("${e.block.y}" == config.get("diamond.y")) {
                if ("${e.block.z}" == config.get("diamond.z")) {
                    Bukkit.broadcastMessage("§bダイヤのスポンジが破壊されました")
                    DiamondSponges(true)
                    BlueWinChecker()
                    e.block.setType(Material.BEDROCK)
                }else e.isCancelled = true
            }else e.isCancelled = true
        }else e.isCancelled = true
    }else e.isCancelled = true
}