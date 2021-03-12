package test

import main.pizzabot.Pizzabot
import org.junit.Test
import kotlin.test.assertEquals


class PizzabotTest {

    @Test
    fun `result should be equals to ennndeeend after passing  5x5 (1, 3) (4, 4)`() {
        val pizzabot = Pizzabot(arrayOf("5x5 (1, 3) (4, 4)"))
        pizzabot.run()
        assertEquals("ENNNDEEEND", pizzabot.getResult())
    }

    @Test
    fun `result should be equals to end after passing  4x4 (1, 1)`() {
        val pizzabot = Pizzabot(arrayOf("4x4 (1, 1)"))
        pizzabot.run()
        assertEquals("END", pizzabot.getResult())
    }

    @Test
    fun `result should be equals to end after passing  5x5 (0, 0) (1, 3) (4,4) (4, 2) (4, 2) (0, 1) (3, 2) (2, 3) (4, 1)`() {
        val pizzabot = Pizzabot(arrayOf("5x5 (0, 0) (1, 3) (4,4) (4, 2) (4, 2) (0, 1) (3, 2) (2, 3) (4, 1)"))
        pizzabot.run()
        assertEquals("DENNNDEEENDSSDDWWWWSDEEENDWNDEESSD", pizzabot.getResult())
    }
}