package kojogame.koutachan.event

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import java.io.File

object event : Listener {

    @EventHandler
    fun BlockPlaceEvent(e: BlockPlaceEvent) {
        if (e.player.gameMode == GameMode.CREATIVE) {
        } else {
            e.isCancelled = true //キャンセル
        }
    }

    @EventHandler
    fun BlockBreakEvent(e: BlockBreakEvent) = //雑でごり押しのコード
        if (e.player.gameMode == GameMode.CREATIVE) {
        } else {
            if (e.block.type == Material.SPONGE) {
                val File = File("plugins/KojoGame/config.yml")
                val config = YamlConfiguration.loadConfiguration(File)
                if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("iron"))) { //XYZとconfigから比較
                    e.player.sendMessage("§f鉄のスポンジが破壊されました")
                    e.isCancelled = false //ごり押しするためにfalse
                } else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("gold"))) {
                    e.player.sendMessage("§6金のスポンジが破壊されました")
                    e.isCancelled = false
                } else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("diamond"))) {
                    e.player.sendMessage("§bダイヤのスポンジが破壊されました")
                    e.isCancelled = false
                } else
                    e.isCancelled = true
            } else
                e.isCancelled = true
        }

    @EventHandler(priority = EventPriority.HIGH)
    fun onFoodLevelChange(e: FoodLevelChangeEvent) {
        e.isCancelled = true
        e.foodLevel = 20
    }
}