package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        
        // This is to remove unnecessary warnings from your console
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        TestCases tests = new TestCases(); // Initialize your test class

        tests.testCase01();
        tests.testCase02();
        tests.testCase03();
        tests.testCase04();

        tests.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
