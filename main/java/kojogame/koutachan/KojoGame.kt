package kojogame.koutachan

import kojogame.koutachan.commands.cmdSponges
import kojogame.koutachan.model.ScoreBoard
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.plugin.java.JavaPlugin

class KojoGame : JavaPlugin(),Listener {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("setsponges").executor = cmdSponges
        server.pluginManager.registerEvents(ScoreBoard, this)
        server.pluginManager.registerEvents(this, this)
        saveDefaultConfig()
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }

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


    fun GameStarted() {
        //if (GameStarted == false) {
        logger.info("いぇえええええええええい")
        //}
    }
}