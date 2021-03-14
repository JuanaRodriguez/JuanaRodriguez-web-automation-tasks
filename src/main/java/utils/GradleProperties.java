package utils;

public class GradleProperties {
    private static GradleProperties instance;
    private String browser;
    private String site;
    private String email;
    private String password;

    private GradleProperties() {
        initialize();
    }

    public static GradleProperties getInstance() {
        if (instance == null) {
            instance = new GradleProperties();
        }
        return instance;
    }

    private void initialize() {
        browser = System.getProperty("browser");
        site = System.getProperty("site");
        email = System.getProperty("email");
        password = System.getProperty("password");
    }

    public String getBrowser() {
        return browser;
    }

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
