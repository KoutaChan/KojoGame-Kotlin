package kojogame.koutachan.model

import kojogame.koutachan.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

fun SpongeParticle() {
    Bukkit.getScheduler().runTaskTimer(plugin, Runnable {
        val File = File("plugins/KojoGame/config.yml")
        val config = YamlConfiguration.loadConfiguration(File)
        Bukkit.getWorld("${config.get("iron.world")}").spawnParticle(Particle.SPELL_INSTANT,
            config.getString("iron.x").toDouble() + 0.5,
            config.getString("iron.y").toDouble() + 0.5,
            config.getString("iron.z").toDouble() + 0.5, 1)
        Bukkit.getWorld("${config.get("gold.world")}").spawnParticle(Particle.SPELL_INSTANT,
            config.getString("gold.x").toDouble() + 0.5,
            config.getString("gold.y").toDouble() + 0.5,
            config.getString("gold.z").toDouble() + 0.5, 1)
        Bukkit.getWorld("${config.get("diamond.world")}").spawnParticle(Particle.SPELL_INSTANT,
            config.getString("diamond.x").toDouble() + 0.5,
            config.getString("diamond.y").toDouble() + 0.5,
            config.getString("diamond.z").toDouble() + 0.5, 1)
    },0,1)
}