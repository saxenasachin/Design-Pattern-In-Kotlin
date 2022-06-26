import java.io.File

interface EventListener {
    fun update(eventType: String?, file: File?)
}

class EventManager(vararg operations: String) {
    // key - event type value - users list subscribed to this event
    private val listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        for (operation in operations) {
            listeners[operation] = ArrayList<EventListener>()
        }
    }

    fun subscribe(eventType: String?, listener: EventListener) {
        val users = listeners[eventType] ?: return
        users.add(listener)
    }

    fun unsubscribe(eventType: String?, listener: EventListener) {
        val users = listeners[eventType] ?: return
        users.remove(listener)
    }

    fun notify(eventType: String?, file: File?) {
        val users = listeners[eventType] ?: return
        for (listener in users) {
            listener.update(eventType, file)
        }
    }
}

class EventGenerator {
    val events = EventManager("open", "save", "delete")

    private var file: File? = null

    fun openFile(fileName: String) {
        file = File(fileName)
        events.notify("open", file)
    }

    fun saveFile() {
        file?.let {
            events.notify("save", file)
        }
    }

    fun deleteFile() {
        file?.let {
            events.notify("delete", file)
        }
    }
}

class EmailNotificationListener(private val email: String) : EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Email to $email: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class LogOpenListener(private val fileName: String) : EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Save to log $fileName: : Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class DeleteFileListener(private val fileName: String) : EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Delete $fileName: : Someone has performed $eventType operation with the file ${file?.name}")
    }
}