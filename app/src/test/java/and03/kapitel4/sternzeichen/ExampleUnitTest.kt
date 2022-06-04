package and03.kapitel4.sternzeichen

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
   @Test
   fun subtraction_isCorrect() {
       assertEquals(3,4-1)
   }
    @Test
    fun sternzeichen_istSteinbock() {
        assertEquals("Steinbock", sternzeichen(22,12))
        assertEquals("Steinbock", sternzeichen(20,1))
        assertNotEquals("Steinbock", sternzeichen(21,12))
        assertNotEquals("Steinbock", sternzeichen(21,1))
    }
    @Test
    fun sternzeichen_istJungfrau() {
        assertEquals("Jungfrau", sternzeichen(23,9))
        assertEquals("Jungfrau", sternzeichen(24,8))
        assertNotEquals("Jungfrau", sternzeichen(24,9))
        assertNotEquals("Jungfrau", sternzeichen(23,8))
    }
}