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
            "4 9 2 3";
        val output =
            "2";

        assertIO(input, output);
    }

    @Test
    fun 入力例_2() {
        val input =
            "10 40 6 8";
        val output =
            "23";

        assertIO(input, output);
    }

    @Test
    fun 入力例_3() {
        val input =
            "314159265358979323 846264338327950288 419716939 937510582";
        val output =
            "532105071133627368";

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
