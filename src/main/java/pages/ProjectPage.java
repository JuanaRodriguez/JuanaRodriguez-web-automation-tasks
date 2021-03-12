package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProjectPage {

    private WebDriver driver;

    private By title = By.cssSelector(".editable > span:nth-child(1)");
    private By addTask = By.cssSelector(".plus_add_button");


    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(title).getText();
    }

    public String getAddTaskText() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(addTask).getText();
    }
}
