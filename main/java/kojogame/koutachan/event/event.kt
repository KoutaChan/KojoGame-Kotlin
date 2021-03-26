package kojogame.koutachan.event

import kojogame.koutachan.model.BlueWinChecker
import kojogame.koutachan.util.*
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.inventory.CraftItemEvent
import java.io.File

object event : Listener {
    val File = File("plugins/KojoGame/config.yml")

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
                if (GameState.GameState == 2) {
                    val config = YamlConfiguration.loadConfiguration(File)
                    if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("iron"))) { //XYZとconfigから比較
                        Bukkit.broadcastMessage("§f鉄のスポンジが破壊されました")
                        IronSponges(true)
                        BlueWinChecker()
                        e.isCancelled = false //ごり押しするためにfalse
                    } else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("gold"))) {
                        Bukkit.broadcastMessage("§6金のスポンジが破壊されました")
                        GoldSponges(true)
                        BlueWinChecker()
                        e.isCancelled = false
                    } else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("diamond"))) {
                        Bukkit.broadcastMessage("§bダイヤのスポンジが破壊されました")
                        DiamondSponges(true)
                        BlueWinChecker()
                        e.isCancelled = false
                    } else
                        e.isCancelled = true
                } else
                    e.isCancelled = true
            } else
                e.isCancelled = true
        }

    @EventHandler
    fun onFoodLevelChange(e: FoodLevelChangeEvent) {
        e.isCancelled = true
        e.foodLevel = 20
    }

    @EventHandler
    fun CraftItemEvent(e: CraftItemEvent) {
        e.isCancelled = true
    }

    @EventHandler
    fun EntityDamageEvent(e: EntityDamageEvent) {
        if (e.entityType == EntityType.PLAYER) {
            if (GameState.GameState == 0) {
                e.isCancelled = true
            }
        }
    }
}
