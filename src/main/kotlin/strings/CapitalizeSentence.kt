package strings

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


/*
* OUTPUT SHOULD BE AS BELOW
*
* INPUT 1 : flower
* OUTPUT 1 : Flower
*
* INPUT 2 : this is a house
* INPUT 2 : This Is A House
*
* */

object Solution1 {
    fun capitalizeSentence(sentence: String): String {
        var shouldCapitalize = true
        var newSentence = ""
        for (character in sentence) {
            newSentence += if (shouldCapitalize) {
                character.uppercase()
            } else {
                character
            }
            shouldCapitalize = false
            if (character.isWhitespace()) {
                shouldCapitalize = true
            }
        }
        return newSentence
    }
}

object Solution2 {
    fun capitalizeSentence(sentence: String): String {
        return sentence.split(" ").joinToString(" ") { it ->
            it.replaceFirstChar { it.uppercase() }
        }
    }
}

object Solution3 {
    fun capitalizeSentence(sentence: String): String {
        val words = mutableListOf<String>()
        sentence.split(" ").forEach {
            words.add(it[0].uppercase() + it.substring(1))
        }
        return words.joinToString(" ")
    }
}

private class CapitalizeSentenceTest {

    @Test
    fun `"flower" is capitalized to "Flower"`() {
        Assertions.assertEquals(Solution1.capitalizeSentence("flower"), "Flower")
    }

    @Test
    fun `"hello world" is capitalized to "Hello World"`() {
        Assertions.assertEquals(Solution1.capitalizeSentence("hello world"), "Hello World")
    }

    @Test
    fun `"this is a house" is capitalized to "This Is A House"`() {
        Assertions.assertEquals(Solution1.capitalizeSentence("this is a house"), "This Is A House")
    }

}