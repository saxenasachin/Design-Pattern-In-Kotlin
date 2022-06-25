import org.junit.jupiter.api.Test

class ObserverTest {

    @Test
    fun observerTest() {
        val eventGenerator = EventGenerator()

        // listeners
        val emailNotificationListener = EmailNotificationListener("sachin.saxena1790@gmail.com")
        val logOpenListener = LogOpenListener("path/to/log/file.txt")
        val deleteFileListener = DeleteFileListener("path/to/log/file.txt")

        // subscribe
        eventGenerator.events.subscribe("open", emailNotificationListener)
        eventGenerator.events.subscribe("save", logOpenListener)
        eventGenerator.events.subscribe("delete", deleteFileListener)

        // perform operations
        eventGenerator.openFile("text.txt")
        eventGenerator.saveFile()
        eventGenerator.deleteFile()

        println("-------------------")

        // unsubscribe
        eventGenerator.events.unsubscribe("open", emailNotificationListener)

        // perform operations
        eventGenerator.openFile("text.txt")
        eventGenerator.saveFile()
        eventGenerator.deleteFile()

        println("-------------------")

        // unsubscribe
        eventGenerator.events.unsubscribe("delete", deleteFileListener)

        // perform operations
        eventGenerator.openFile("text.txt")
        eventGenerator.saveFile()
        eventGenerator.deleteFile()
    }
}