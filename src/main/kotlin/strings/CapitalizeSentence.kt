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


private class CapitalizeSentenceTest {

    @Test
    fun `"flower" is capitalized to "Flower"`() {
        Assertions.assertEquals(capitalizeSentence("flower"), "Flower")
    }

    @Test
    fun `"hello world" is capitalized to "Hello World"`() {
        Assertions.assertEquals(capitalizeSentence("hello world"), "Hello World")
    }

    @Test
    fun `"this is a house" is capitalized to "This Is A House"`() {
        Assertions.assertEquals(capitalizeSentence("this is a house"), "This Is A House")
    }

}