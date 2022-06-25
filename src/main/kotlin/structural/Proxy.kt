interface Image {
    fun display()
}

class RealImage(private val fileName: String) : Image {
    override fun display() {
        println("RealImage Displaying $fileName")
    }

    init {
        println("RealImage Loading $fileName")
    }
}

class ProxyImage(private val fileName: String) : Image {
    private var image: RealImage? = null

    override fun display() {
        println("ProxyImage Displaying $fileName")
        if (image == null) {
            image = RealImage(fileName)
        }
        image?.display()
    }
}