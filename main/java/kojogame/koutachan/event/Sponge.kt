package kojogame.koutachan.event

import kojogame.koutachan.KojoGame
import kojogame.koutachan.model.BlueWinChecker
import kojogame.koutachan.util.DiamondSponges
import kojogame.koutachan.util.GoldSponges
import kojogame.koutachan.util.IronSponges
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.block.BlockBreakEvent
import java.io.File

fun iron(e: BlockBreakEvent) {
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

fun SpongeParticle() {
    Bukkit.getScheduler().runTaskTimer(KojoGame.plugin, Runnable {
        val File = File("plugins/KojoGame/config.yml")
        val config = YamlConfiguration.loadConfiguration(File)
        Bukkit.getWorld("${config.get("iron.world")}").spawnParticle(
            Particle.SPELL_INSTANT,
            config.getString("iron.x").toDouble() + 0.5,
            config.getString("iron.y").toDouble() + 0.5,
            config.getString("iron.z").toDouble() + 0.5, 1)
        Bukkit.getWorld("${config.get("gold.world")}").spawnParticle(
            Particle.SPELL_INSTANT,
            config.getString("gold.x").toDouble() + 0.5,
            config.getString("gold.y").toDouble() + 0.5,
            config.getString("gold.z").toDouble() + 0.5, 1)
        Bukkit.getWorld("${config.get("diamond.world")}").spawnParticle(
            Particle.SPELL_INSTANT,
            config.getString("diamond.x").toDouble() + 0.5,
            config.getString("diamond.y").toDouble() + 0.5,
            config.getString("diamond.z").toDouble() + 0.5, 1)
    },0,1)
}

fun ResetSponges() {
    val File = File("plugins/KojoGame/config.yml")
    val config = YamlConfiguration.loadConfiguration(File)
    Bukkit.getWorld("${config.get("iron.world")}").getBlockAt(config.getString("iron.x").toInt(),config.getString("iron.y").toInt(),config.getString("iron.z").toInt()).setType(Material.SPONGE)
    Bukkit.getWorld("${config.get("gold.world")}").getBlockAt(config.getString("gold.x").toInt(),config.getString("gold.y").toInt(),config.getString("gold.z").toInt()).setType(Material.SPONGE)
    Bukkit.getWorld("${config.get("diamond.world")}").getBlockAt(config.getString("diamond.x").toInt(),config.getString("diamond.y").toInt(),config.getString("diamond.z").toInt()).setType(Material.SPONGE)
}