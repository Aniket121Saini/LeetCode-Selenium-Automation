package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String currentURL = driver.getCurrentUrl();

        if (currentURL.contains("leetcode")) {
            System.out.println("Test case: testCase01 is passed");
        } else {
            System.out.println("Test case: testCase01 is failed");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");

        driver.get("https://leetcode.com/");

        WebDriverWait wait = new WebDriverWait(
            driver, java.time.Duration.ofSeconds(20)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement questionsLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.linkText("View Questions"))
        );
        questionsLink.click();

        wait.until(ExpectedConditions.urlContains("problemset"));

        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);

        if (url.contains("problemset")) {
            System.out.println("URL contains problemset");
        }

        String[] links = {
            "/problems/two-sum",
            "/problems/add-two-numbers",
            "/problems/longest-substring-without-repeating-characters",
            "/problems/median-of-two-sorted-arrays",
            "/problems/longest-palindromic-substring"
        };

        for (int i = 0; i < links.length; i++) {
            WebElement question = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//a[contains(@href,'" + links[i] + "')]")
                )
            );

            String name = question.getText().trim();

            System.out.println(name);
        }

        System.out.println("End Test case: testCase02");
    }



    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        WebElement questionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Questions")));
        questionsLink.click();

        String currentURL = driver.getCurrentUrl();
        boolean hasProblemset = currentURL.contains("problemset");
        System.out.println("Current URL: " + currentURL);
        if (hasProblemset) {
            System.out.println("URL does contain 'problemset'.");
        } else {
            System.out.println("URL does not contain 'problemset'.");
        }

        WebElement firstQuestion = driver.findElement( By.xpath("//a[@href='/problems/two-sum']") );
        firstQuestion.click();
        wait.until(ExpectedConditions.urlContains("two-sum")); // Wait for 2 seconds to ensure the page loads
        
        String currentURL1 = driver.getCurrentUrl();
        if (currentURL1.contains("two-sum")) {
            System.out.println("Test case: testCase03 is passed");
        } else {
            System.out.println("Test case: testCase03 is failed");
        }
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() {
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        WebElement questionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Questions")));
        questionsLink.click();

        String currentURL = driver.getCurrentUrl();
        boolean hasProblemset = currentURL.contains("problemset");
        System.out.println("Current URL: " + currentURL);
        if (hasProblemset) {
            System.out.println("URL does contain 'problemset'.");
        } else {
            System.out.println("URL does not contain 'problemset'.");
        }

        WebElement firstQuestion = driver.findElement( By.xpath("//a[@href='/problems/two-sum']") );
        firstQuestion.click();
        wait.until(ExpectedConditions.urlContains("two-sum"));
        
        String currentURL1 = driver.getCurrentUrl();
        if (currentURL1.contains("two-sum")) {
            System.out.println("URL does contain 'two-sum'.");
        } else {
            System.out.println("URL does not contain 'two-sum'.");
        }

        WebElement submissionsTab = wait.until( ExpectedConditions.elementToBeClickable(By.id("submissions_tab")) ); 
        submissionsTab.click(); WebElement loginText = wait.until( ExpectedConditions.visibilityOfElementLocated( By.linkText("Register or Log in") ) ); 
        String actualText = loginText.getText(); 
        System.out.println(actualText);

        // if (loginText.isDisplayed()) { 
        //     System.out.println("Register or Login"); 
        // }else{ 
        //     System.out.println("Register or Login is not displayed"); 
        // }

        System.out.println("end Test case: testCase04");
    }
    //happy coding
}

