import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class AreaConverterTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", new File("src/main/resources/chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver();

        File htmlFile = new File("src/main/resources/page.html");
        driver.get(htmlFile.toURI().toString());
    }

    @Test
    public void testSquareMetersToHectares() {
        testConversion("10000", "sqm", "hectare", "10000 кв. м = 1.0000 хектара");
    }

    @Test
    public void testHectaresToSquareMeters() {
        testConversion("1", "hectare", "sqm", "1 хектара = 10000.0000 кв. м");
    }

    @Test
    public void testInvalidInput() {
        WebElement input = driver.findElement(By.id("inputValue"));
        input.clear();
        input.sendKeys("abc");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.getText().contains("Моля, въведете валидна стойност"));
    }

    private void testConversion(String inputValue, String fromUnit, String toUnit, String expectedPrefix) {
        WebElement input = driver.findElement(By.id("inputValue"));
        WebElement fromSelect = driver.findElement(By.id("fromUnit"));
        WebElement toSelect = driver.findElement(By.id("toUnit"));
        WebElement button = driver.findElement(By.tagName("button"));
        WebElement result = driver.findElement(By.id("result"));

        input.clear();
        input.sendKeys(inputValue);

        new Select(fromSelect).selectByValue(fromUnit);
        new Select(toSelect).selectByValue(toUnit);

        button.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(result.getText().startsWith(expectedPrefix));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
