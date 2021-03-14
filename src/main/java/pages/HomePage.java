package pages;

public class HomePage extends BasePage {
    public LeftMenuPage leftMenuPage;
    public ContentAreaPage contentAreaPage;
    public HeaderPage headerPage;

    public HomePage() {

        leftMenuPage = new LeftMenuPage();
        contentAreaPage = new ContentAreaPage();
        headerPage = new HeaderPage();
    }
}
