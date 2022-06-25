import kotlin.test.Test
import kotlin.test.assertEquals

class CompositeTest {
    @Test
    fun testComposite() {
        val memory = Memory()
            .add(ROM())
            .add(RAM())

        val pc = Computer()
            .add(memory)
            .add(HardDrive())
            .add(Processor())

        println("Memory Price : ${memory.price}")
        println("PC Price : ${pc.price}")
        assertEquals(memory.price, 175)
        assertEquals(pc.price, 1425)
    }
}