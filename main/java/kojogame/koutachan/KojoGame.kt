package kojogame.koutachan

import kojogame.koutachan.commands.cmdSponges
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.server.BroadcastMessageEvent
import org.bukkit.plugin.java.JavaPlugin




class KojoGame : JavaPlugin(), Listener {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("setsponges").executor = cmdSponges
        server.pluginManager.registerEvents(this, this)
        val config = getConfig() //config.options().copyDefaults(true)
        saveDefaultConfig()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    fun onPlace(e: BlockPlaceEvent) {
        if (e.player.getGameMode() == GameMode.CREATIVE) {
        } else {
            e.setCancelled(true) //キャンセル
        }
    }

    @EventHandler
    fun onBreak(e: BlockBreakEvent) { //雑でごり押しのコード
        if (e.player.getGameMode() == GameMode.CREATIVE) {
        } else {
            if (e.block.type == Material.SPONGE) {
                if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("iron"))) { //XYZとconfigから比較
                    e.player.sendMessage("[1]")
                    e.setCancelled(false) //ごり押しするためにfalse
                }else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("gold"))) {
                    e.player.sendMessage("[2]")
                    e.setCancelled(false)
                }else if (listOf(e.block.x, e.block.y, e.block.z) == (config.get("diamond"))) {
                    e.player.sendMessage("[3]")
                    e.setCancelled(false)
                } else
                    e.setCancelled(true)
            } else
                e.setCancelled(true)
        }
    }
}
