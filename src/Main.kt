fun main() {
    val server = WebSocketAudioServer(2333)
    server.start()
    println("🔊 Custom Lavalink läuft auf Port 2333")
}
