package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public LeftMenuPage leftMenuPage;
    public ContentAreaPage contentAreaPage;
    public HeaderPage headerPage;

    public HomePage(WebDriver driver) {
        super(driver);
        leftMenuPage = new LeftMenuPage(driver);
        contentAreaPage = new ContentAreaPage(driver);
        headerPage = new HeaderPage(driver);
    }
}
