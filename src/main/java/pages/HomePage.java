package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By addProjectLink = By.linkText("Add Project");
    private By title = By.cssSelector(".view_header__content > h1:nth-child(1) > span");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(title).getText();
    }


    public AddProjectPage clickAddProjectLink() {
        driver.findElement(addProjectLink).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new AddProjectPage(driver);
    }
}
