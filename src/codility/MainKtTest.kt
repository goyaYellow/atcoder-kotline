package codility

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {

    @Test
    fun 入力例_1() {

        val input = intArrayOf(3, 1, 2, 5, 4)

        val actual = solution(input)
        val expect = 60

        Assert.assertThat(actual, equalTo(expect))
    }

    @Test
    fun 入力例_2() {

        val input = intArrayOf(-1, -2, -3, -4, -5)

        val actual = solution(input)
        val expect = -6

        Assert.assertThat(actual, equalTo(expect))
    }

    @Test
    fun 入力例_3() {

        val input = intArrayOf(0, -1, -2, -3, -4, -5)

        val actual = solution(input)
        val expect = 0

        Assert.assertThat(actual, equalTo(expect))
    }

    @Test
    fun 入力例_4() {

        val input = intArrayOf(0, -1, -2, -3, -4, -5, 10, 2)

        val actual = solution(input)
        val expect = 200

        Assert.assertThat(actual, equalTo(expect))
    }

    @Test
    fun 入力例_5() {

        val input = intArrayOf(0, -1, -2, -3, -3, -6, 10, 4, 5)

        val actual = solution(input)
        val expect = 200

        Assert.assertThat(actual, equalTo(expect))
    }

    @Test
    fun 入力例_6() {

        val input = intArrayOf(-1, -2, -3, -3, -6, 10, 4, 5)

        val actual = solution(input)
        val expect = 200

        Assert.assertThat(actual, equalTo(expect))
    }
}
