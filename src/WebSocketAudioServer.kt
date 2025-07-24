import org.java_websocket.server.WebSocketServer
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import java.net.InetSocketAddress
import org.json.JSONObject

class WebSocketAudioServer(port: Int) : WebSocketServer(InetSocketAddress(port)) {
    private val audioHandler = AudioHandler()

    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        println("🔌 Verbindung: ${conn?.remoteSocketAddress}")
    }

    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        println("❌ Verbindung getrennt: ${conn?.remoteSocketAddress}")
    }

    override fun onMessage(conn: WebSocket?, message: String?) {
        println("📥 Befehl: $message")
        val json = JSONObject(message)
        when (json.getString("op")) {
            "play" -> {
                val url = json.getString("url")
                audioHandler.play(url)
            }
            "stop" -> audioHandler.stop()
            "pause" -> audioHandler.pause(true)
            "resume" -> audioHandler.pause(false)
            else -> println("⚠️ Unbekannter Befehl")
        }
    }

    override fun onError(conn: WebSocket?, ex: Exception?) {
        ex?.printStackTrace()
    }

    override fun onStart() {
        println("✅ WebSocket gestartet")
    }
}
