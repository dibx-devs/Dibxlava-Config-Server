import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class AudioHandlerTest {
    @Test
    fun `test play URL`() {
        val handler = AudioHandler()
        handler.play("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
        assertNotNull(handler)
    }
}
