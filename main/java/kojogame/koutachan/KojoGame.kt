package kojogame.koutachan

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
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

    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (command?.getName().equals("setsponges")) {
            if (sender is Player) {
                if (args?.isNotEmpty()!!) {
                    if (args?.get(0) == "iron") {
                        config.set(
                            "iron",
                            listOf(
                                sender.getTargetBlock(null, 100).x,
                                sender.getTargetBlock(null, 100).y,
                                sender.getTargetBlock(null, 100).z
                            )
                        )
                        saveConfig()
                        sender.sendMessage(
                            "§f保存しました！\nX:${
                                sender.getTargetBlock(
                                    null,
                                    100
                                ).x
                            } \nY:${sender.getTargetBlock(null, 100).y} \nZ:${sender.getTargetBlock(null, 100).z}"
                        )
                    } else if (args?.get(0) == "gold") {
                        config.set(
                            "gold",
                            listOf(
                                sender.getTargetBlock(null, 100).x,
                                sender.getTargetBlock(null, 100).y,
                                sender.getTargetBlock(null, 100).z
                            )
                        )
                        saveConfig()
                        sender.sendMessage(
                            "§6保存しました！\nX:${
                                sender.getTargetBlock(
                                    null,
                                    100
                                ).x
                            } \nY:${sender.getTargetBlock(null, 100).y} \nZ:${sender.getTargetBlock(null, 100).z}"
                        )
                    } else if (args?.get(0) == "diamond") {
                        config.set(
                            "diamond",
                            listOf(
                                sender.getTargetBlock(null, 100).x,
                                sender.getTargetBlock(null, 100).y,
                                sender.getTargetBlock(null, 100).z
                            )
                        )
                        saveConfig()
                        sender.sendMessage(
                            "§b保存しました！\nX:${
                                sender.getTargetBlock(
                                    null,
                                    100
                                ).x
                            } \nY:${sender.getTargetBlock(null, 100).y} \nZ:${sender.getTargetBlock(null, 100).z}"
                        )
                    } else sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond]")
                } else sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond]")
            } else sender?.sendMessage("§cYou can't execute this command from console!")
        }
        return true
    }
}

