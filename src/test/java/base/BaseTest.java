package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.WebDriverProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest implements WebDriverProvider {
    protected WebDriver driver;

    protected static Properties props;

    protected static String baseURL;
    protected static String login;
    protected static String password;
    protected static String baseUrl;

    @BeforeSuite(alwaysRun = true)
    public void loadProperties() throws IOException {
        props = new Properties();
        try (FileInputStream fis = new FileInputStream("local.properties")) {
            props.load(fis);
        }

        login    = props.getProperty("login");
        password = props.getProperty("password");
        baseURL  = props.getProperty("baseURL");
        baseUrl = props.getProperty("baseUrl");
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("mozilla")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
