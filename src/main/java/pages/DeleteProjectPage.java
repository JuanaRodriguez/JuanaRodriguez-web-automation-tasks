package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProjectPage extends BasePage {

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div[3]/div/form/footer/button[1]")
    @CacheLookup
    WebElement confirmationDeleteProject;

    public DeleteProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage clickConfirmationDeleteProject() {
        confirmationDeleteProject.click();
        return new HomePage();
    }
}
