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
                }else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("gold"))) {
                    e.player.sendMessage("§6金のスポンジが破壊されました")
                    e.isCancelled = false
                }else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("diamond"))) {
                    e.player.sendMessage("§bダイヤのスポンジが破壊されました")
                    e.isCancelled = false
                }else
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
                        val ironX = sender.getTargetBlock(null, 100).x
                        val ironY = sender.getTargetBlock(null, 100).y
                        val ironZ = sender.getTargetBlock(null, 100).z
                        config.set("iron", listOf(ironX, ironY, ironZ))
                        saveConfig()
                        sender.sendMessage("§f保存しました！\nX:$ironX \nY:$ironY \nZ:$ironZ")
                    } else if (args?.get(0) == "gold") {
                        val goldX = sender.getTargetBlock(null, 100).x
                        val goldY = sender.getTargetBlock(null, 100).y
                        val goldZ = sender.getTargetBlock(null, 100).z
                        config.set("gold", listOf(goldX, goldY, goldZ))
                        saveConfig()
                        sender.sendMessage("§6保存しました！\nX:$goldX \nY:$goldY \nZ:$goldZ")
                    } else if (args?.get(0) == "diamond") {
                        val diamondX = sender.getTargetBlock(null, 100).x
                        val diamondY = sender.getTargetBlock(null, 100).y
                        val diamondZ = sender.getTargetBlock(null, 100).z
                        config.set("diamond", listOf(diamondX, diamondY, diamondZ))
                        saveConfig()
                        sender.sendMessage("§b保存しました！\nX:$diamondX \nY:$diamondY \nZ:$diamondZ")
                    } else sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond]")
                } else sender.sendMessage("§c使い方: /setsponges [iron / gold / diamond]")
            } else sender?.sendMessage("§cYou can't execute this command from console!")
        }
        return true
    }
}

