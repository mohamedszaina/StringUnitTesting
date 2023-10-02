import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.StrUtil;

public class StrUtilTest {

    @DataProvider(name = "lengthData")
    public Object[][] lengthData() {
        return new Object[][] {
                { "Invalid", 7 },
                { "Excellent", 9 },
                { "Very Good", 9 },
                { "Good", 4 },
                { "Accepted", 8 },
                { "Failed", 6 },
                { "", 0 },
                { " ", 1 },
                { " #", 2 },
                { null, 0 }, // Test with null input
                { "Test\nNewline", 12 }, // Test with newline character
        };
    }

    @Test(dataProvider = "lengthData")
    public void testStringLength(String input, int expected) {
        int actual = StrUtil.stringLength(input);
        Assert.assertEquals(actual, expected, "Failed for input: " + input);
    }

    @Test(dataProvider = "lengthData")
    public void testStringLengthTrim(String input, int expected) {
        int actual = StrUtil.stringLengthTrim(input);
        Assert.assertEquals(actual, expected, "Failed for input: " + input);
    }
}
