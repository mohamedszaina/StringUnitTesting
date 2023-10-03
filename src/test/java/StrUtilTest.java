import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.example.StrUtil;

public class StrUtilTest {
    @BeforeClass
    public void printBeforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void printBefore(ITestResult res) {
        System.out.println("Before: " + res.getMethod().getMethodName());
    }


    @AfterMethod
    public void printAfter(ITestResult res) {
        System.out.println("After: " + res.getMethod().getMethodName());
    }
    @AfterClass
    public void printAfterClass() {
        System.out.println("After Class");
    }

    @DataProvider(name = "lengthData")
    public Object[][] lengthData() {
        return new Object[][]{{"Invalid", 7}, {"Excellent", 9}, {"Very Good", 9}, {"Good", 4}, {"Accepted", 8}, {"Failed", 6}, {"", 0}, {" ", 1}, {" #", 2}, {null, 0},
                // Test with null input
                {"Test\nNewline", 12}, // Test with newline character
        };
    }


    @Test(dataProvider = "lengthData", priority = 2)
    public void testStringLength(String input, int expected) {
        int actual = StrUtil.stringLength(input);
        Assert.assertEquals(actual, expected, "Failed for input: " + input);
    }

    @Test(dataProvider = "lengthData", priority = 1)
    public void testStringLengthTrim(String input, int expected) {
        int actual = StrUtil.stringLengthTrim(input);
        Assert.assertEquals(actual, expected, "Failed for input: " + input);
    }
}
