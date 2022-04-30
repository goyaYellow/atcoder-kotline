import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {

    @Test
    fun 入力例_1() {
        val input =
            "3" + System.lineSeparator() +
                    "6 2 3";
        val output =
            "2";

        assertIO(input, output);
    }

    @Test
    fun 入力例_2() {
        val input =
            "1" + System.lineSeparator() +
                    "2";
        val output =
            "0";

        assertIO(input, output);
    }

    @Test
    fun 入力例_3() {
        val input =
            "10" + System.lineSeparator() +
                    "1 3 2 4 6 8 2 2 3 7";
        val output =
            "62";

        assertIO(input, output);
    }

    private fun assertIO(input: String, output: String) {
        val sysIn = ByteArrayInputStream(input.toByteArray())
        System.setIn(sysIn)

        val sysOut = ByteArrayOutputStream()
        System.setOut(PrintStream(sysOut))

        abc000X()

        Assert.assertThat(sysOut.toString(), equalTo(output + System.lineSeparator()))
    }
}
