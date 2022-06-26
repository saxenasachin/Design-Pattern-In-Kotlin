interface Command {
    fun execute()
}

class OrderAddCommand(private val id: Long) : Command {
    override fun execute() {
        println("Adding order with id $id")
    }
}

class OrderPayCommand(private val id: Long) : Command {
    override fun execute() {
        println("Paying for order with id $id")
    }
}

class CommandProcessor {
    private val queue = arrayListOf<Command>()

    fun addToQueue(command: Command): CommandProcessor = apply { queue.add(command) }

    fun processCommand(): CommandProcessor =
        apply {
            queue.forEach { it.execute() }
            queue.clear()
        }
}