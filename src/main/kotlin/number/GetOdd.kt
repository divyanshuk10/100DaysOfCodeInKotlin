package number

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/*
* OUTPUT SHOULD BE AS BELOW
*
* INPUT 1 : listOf(1, 2, 3)
* OUTPUT 1 : 1, 3
*
* INPUT 2 : listOf(4, 6, 8, 7, 9)
* INPUT 2 : 7, 9
*
* */

object Solution1 {
    fun getOdd(list: List<Int>): List<Int> {
        return list.filter { i -> i % 2 != 0 }
    }
}

// recursive approach
object Solution2 {
    fun getOdd(list: List<Int>): List<Int> {
        if (list.isEmpty()) {
            return list
        }
        return if (list.first() % 2 == 1) {
            mutableListOf(list.first()) + getOdd(list.drop(1))
        } else {
            getOdd(list.drop(1))
        }
    }
}


private class Test {

    @Test
    fun `"filter all odd items in a list"`() {
        Assertions.assertEquals(Solution1.getOdd(listOf(1, 2, 3, 4, 5, 666, 77)), listOf(1, 3, 5, 77))
    }
}