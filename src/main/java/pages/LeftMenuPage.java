package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPage extends BasePage {

    @FindBy(css="#list_holder > div.sidebar_expansion_panel.expansion_panel.expansion_panel--expanded > div.expansion_panel__header > div > button > svg")
    @CacheLookup
    WebElement addButton;

    public LeftMenuPage(){

        PageFactory.initElements(driver, this);
    }

    public AddProjectPage clickAddProjectButton(){
        addButton.click();
        return new AddProjectPage();
    }
}
