package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;
import utils.GradleProperties;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance = null;

    private WebDriver driver;
    private WebDriverWait wait;

    protected DriverManager(){
        initialize();
    }
  /*
  se utiliza static para poder hacer la llamada directo al getinstance del BasePage, para no instanciar el DriveManager
   */
    public static DriverManager getInstance(){ //este es el singleton pattern
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
/* este metodo sera privado solo se va poder acceder desde el constructor de esta clase DriveManager*/
    private void initialize() {
        if(GradleProperties.getInstance().getBrowser().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ConfigProperties.getInstance().getChromeDriver());
            driver = new ChromeDriver(); //definimos nuestra instancia de chrome driver
        }
        if(GradleProperties.getInstance().getBrowser().equals("firefox")) {}

        driver.manage().timeouts().implicitlyWait(ConfigProperties.getInstance().getImplicitTime(), TimeUnit.SECONDS);// aca definimos nuestro implicitWait
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, ConfigProperties.getInstance().getExplicitTime());
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }

    public void setUrl(String url){
        driver.get(url);
    }

    public void quitDriver(){
//        driver.quit();
        instance = null;
    }
}
