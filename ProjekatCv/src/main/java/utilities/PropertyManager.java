package utilities;



import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    private static String url;
    private static String driverPath;
    private static String loginUsername;
    private static String badLoginPassword;
    private static String loginPassword;
    private static String emptyUsername;
    private static String emptyPassword;
    private static String firstName;

    private static String lastName;

    private static String zipPostalCod;

    public static PropertyManager getInstance() {
        PropertyManager instance = new PropertyManager();
        Properties prop = new Properties();

        try {
            FileInputStream fi = new FileInputStream("src/main/resources/configuration.properties");
            prop.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        url = prop.getProperty("url");
        driverPath = prop.getProperty("driverPath");
        loginUsername = prop.getProperty("loginUserName");
        badLoginPassword = prop.getProperty("badLoginPassword");
        loginPassword = prop.getProperty("loginPassword");
        emptyUsername = prop.getProperty("emptyUsername");
        emptyPassword = prop.getProperty("emptyPassword");
        firstName = prop.getProperty("firstName");
        lastName = prop.getProperty("lastName");
        zipPostalCod = prop.getProperty("zipPostalCod");

        return instance;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getBadLoginPassword() {return badLoginPassword;}

    public String getLoginPassword() {return loginPassword;}

    public String getEmptyUsername(){return emptyUsername;}

    public String getEmptyPassword(){return emptyPassword;}

    public String getFirstName(){return firstName;}

    public String getLastName(){return lastName;}

    public String getZipPostalCod(){return zipPostalCod;}

    }
