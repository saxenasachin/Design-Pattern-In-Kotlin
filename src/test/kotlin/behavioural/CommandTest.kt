import org.junit.jupiter.api.Test

class CommandTest {

    @Test
    fun testCommand() {
        CommandProcessor()
            .addToQueue(OrderAddCommand(1L))
            .addToQueue(OrderAddCommand(2L))
            .addToQueue(OrderPayCommand(1L))
            .addToQueue(OrderPayCommand(2L))
            .processCommand()
    }
}