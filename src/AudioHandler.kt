import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer

class AudioHandler {
    private val playerManager: AudioPlayerManager = DefaultAudioPlayerManager()
    private val player: AudioPlayer

    init {
        AudioSourceManagers.registerRemoteSources(playerManager)
        player = playerManager.createPlayer()
    }

    fun play(url: String) {
        playerManager.loadItem(url) { result ->
            val track = result.track ?: result.playlist?.tracks?.firstOrNull()
            if (track != null) {
                println("▶️ Spiele: ${track.info.title}")
                player.playTrack(track)
            } else {
                println("⚠️ Keine Tracks gefunden")
            }
        }
    }

    fun stop() {
        player.stopTrack()
    }

    fun pause(paused: Boolean) {
        player.isPaused = paused
    }
}
