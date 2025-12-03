package base;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiBaseTest {

    protected String baseUrl;
    protected String login;
    protected String password;
    protected int projectId;
    protected String projectName;

    @BeforeClass
    public void loadProperties() {
        try (FileInputStream fis = new FileInputStream("local.properties")) {
            Properties props = new Properties();
            props.load(fis);

            baseUrl = props.getProperty("baseUrl");
            login = props.getProperty("login");
            password = props.getProperty("password");
            projectId = Integer.parseInt(props.getProperty("projectId"));
            projectName = props.getProperty("projectName");

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке файла local.properties", e);
        }
    }
}