package pages;

public class HomePage extends BasePage {
    public LeftMenuPage leftMenuPage;
    public ContentBoardProjectPage contentBoardProjectPage;
    public HeaderPage headerPage;
    public ContentAreaPage contentAreaPage;


    public HomePage() {
        leftMenuPage = new LeftMenuPage();
        contentBoardProjectPage = new ContentBoardProjectPage();
        headerPage = new HeaderPage();
        contentAreaPage = new ContentAreaPage();
    }
}
