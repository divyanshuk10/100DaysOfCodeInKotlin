package number

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
*
* Given positive integer n implement a function which calculates
* sum of all numbers from 1 up to (and including) number n.
*
*
* OUTPUT SHOULD BE AS BELOW
*
* addUpTo(1) // 1
* addUpTo(2) // 3
* addUpTo(3) // 6
*
* */

object AddUp {

    fun solution1(number: Int): Int {
        return number.downTo(1).sum()
    }

    fun solution2(number: Int): Int {
        return (1..number).fold(0) { added, toBeAdd -> added + toBeAdd }
    }

    fun solution3(number: Int): Int {
        return number * (number + 1) / 2
    }

    fun solution4(number: Int): Int {
        var sum: Int = 0
        (1..number).forEach { sum += it }
        return sum
    }

    fun solution5(number: Int): Int {
        return (0..number).sum()
    }

    fun solution6(number: Int): Int {
        if (number == 1) {
            return 1
        }
        return number + solution6(number - 1)
    }
}

private class TestAddUp {

    @Test
    fun `add up to 1`() {
        Assertions.assertEquals(AddUp.solution1(1), 1)
    }

    @Test
    fun `add up to 3`() {
        Assertions.assertEquals(AddUp.solution2(3), 6)
    }

    @Test
    fun `add up to 10`() {
        Assertions.assertEquals(AddUp.solution3(10), 55)
    }
}
