import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todoist.com/users/showlogin");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("jfr.rodriguezz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("button.submit_btn.ist_button.ist_button_red.sel_login")).click();
        driver.quit();

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setUp();
    }
}
