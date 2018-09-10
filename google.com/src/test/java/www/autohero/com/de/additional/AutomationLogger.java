package www.autohero.com.de.additional;

import org.testng.Assert;

public class AutomationLogger {

    public static void printInfo(String msg) {
        System.out.println("[INFO]: " + msg);
        Assert.assertTrue(true, msg);
    }

    public static void printPassed(String msg) {
        System.out.println("[PASS]: " + msg);
        Assert.assertTrue(true, msg);
    }

    public static void printFailed(String msg) {
        System.out.println("[FAIL]: " + msg);
        Assert.fail(msg);
    }
}
