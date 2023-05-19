package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

 //   WebDriver wd;
    EventFiringWebDriver wd;

    HelperUser user;
    Properties properties;
    String browser;

    public ApplicationManager(){
               properties = new Properties();
    }

    public void init() throws IOException {

        String configuration = System.getProperty("configuration", "config");
//        properties.load(new FileReader(new File("src/test/resources/config.properties")));
         properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",configuration))));
//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
//        wd.manage().window().maximize();
//        wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        user = new HelperUser(wd);
    }

    public void stop(){

     //   wd.quit();
    }
    public HelperUser getUser(){
        return user;
    }

    public String getEmail(){
        return properties.getProperty("web.email");
    }
    public String getPassword(){
        return properties.getProperty("web.password");
    }
}
