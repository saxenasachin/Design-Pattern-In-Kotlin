import org.junit.jupiter.api.Test

class ProxyTest {
    @Test
    fun proxyTest() {
        val proxyImage = ProxyImage("test.jpg")

        // load image from disk
        proxyImage.display()
        println("--------------------")

        // load image from "cache"
        proxyImage.display()
    }
}