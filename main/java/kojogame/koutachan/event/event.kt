package kojogame.koutachan.event

import kojogame.koutachan.State
import kojogame.koutachan.util.GameState
import org.bukkit.GameMode
import org.bukkit.Material
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
    fun BlockBreakEvent(e: BlockBreakEvent) {
        if (e.player.gameMode == GameMode.CREATIVE) {
        } else {
            if (e.block.type == Material.SPONGE) {
                if (State == GameState.PLAYING) {
                    iron(e)
                    gold(e)
                    diamond(e)
                } else e.isCancelled = true
            } else e.isCancelled = true
        }
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
            if (State != GameState.PLAYING) {
                e.isCancelled = true
            }
        }
    }
}