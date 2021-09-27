package number

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
*
* Given two ranges implement a function which checks if range1 contains range2.
*
* OUTPUT SHOULD BE AS BELOW
*
* containsRange(5..7, 5..7) // true
* containsRange(1..12, 5..7) // true
* containsRange(5..8, 5..9) // false
*
* */



object Range {
    fun containsRangeSolution1(range1: IntRange, range2: IntRange): Boolean {
        range2.forEach { it -> if (!range1.contains(it)) return false }
        return true
    }

    fun containsRangeSolution2(range1: IntRange, range2: IntRange): Boolean {
        return range2.first >= range1.first && range2.last <= range1.last
    }
}

private class TestContainsRange {

    @Test
    fun ` 5-7 range contains 5-7`() {
        Assertions.assertEquals(Range.containsRangeSolution1(5..7, 5..7), true)
    }

    @Test
    fun ` 12-17 range contains 12-14`() {
        Assertions.assertEquals(Range.containsRangeSolution1(12..17, 12..14), true)
    }

}