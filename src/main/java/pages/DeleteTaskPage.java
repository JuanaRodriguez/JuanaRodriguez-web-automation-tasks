package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteTaskPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"reactist-modal-box-26\"]/form/footer/button[1]")
    @CacheLookup
    WebElement confirmationDeleteTask;

    public DeleteTaskPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage clickConfirmationDeleteTask() {

        confirmationDeleteTask.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        return new HomePage();
    }
}
