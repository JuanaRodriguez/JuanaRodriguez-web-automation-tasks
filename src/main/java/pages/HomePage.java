package pages;


/*
* EL homepage abstrae la pagina de todoist en 3 nuevos pages: header, leftPanel y el content
* */
public class HomePage extends BasePage{
    public LeftMenuPage leftMenuPage; //declara la clase LeftMenuPage
    public ContentAreaPage contentAreaPage; //declara la clase ContentAreaPage
    public HeaderPage headerPage; //declara la clase HeaderPage

    public HomePage() {

        leftMenuPage = new LeftMenuPage (); // instancia la clase LeftMenuPage en el instructor
        contentAreaPage = new ContentAreaPage(); // instancia la clase ContentAreaPage en el instructor
        headerPage = new HeaderPage(); // instancia la clase HeaderPage en el instructor
    }

}
