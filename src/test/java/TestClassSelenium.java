import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassSelenium {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test(groups = "smoke")
    public void openDriverTest() throws Exception {
        driver.get("https://yandex.ru/");
        driver.findElement(By.className("home-logo__default")).isDisplayed();
    }

    @AfterMethod
    public void close(){
        driver.quit();
        driver = null;
    }
}
