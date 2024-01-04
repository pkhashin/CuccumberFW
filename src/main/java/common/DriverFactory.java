package common;

import exception.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Properties;

public class DriverFactory {
  WebDriver driver;
     Properties prop;
     public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

     public static String highlight = null;
//     public void initDriver(Yaml yaml){
//
//          String browserName=yaml.getName().;
//
//     }
//
//     public Yaml initPropertiess() throws FileNotFoundException {
//
//          InputStream inputStream=new FileInputStream(".src/main/resources/application.yaml");
//          Yaml yaml=new Yaml();
//          Map<String,Object> data=yaml.load(inputStream);
//          return yaml;
//     }

     public Properties initProperties() throws FileNotFoundException {

          FileInputStream fileInputStream=new FileInputStream("src/main/resources/config.properties");
          prop=new Properties();
          try {
              prop.load(fileInputStream);
          }catch(IOException e){
e.printStackTrace();
          }
          return prop;
     }

     public WebDriver initDriver(Properties prop){
          String browserName=prop.getProperty("browser");
          switch (browserName.toLowerCase().trim()){
              case "chrome":
               WebDriverManager.chromedriver().setup();
               tlDriver.set(new ChromeDriver());
               break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  tlDriver.set(new FirefoxDriver());
                  break;
              default:
                  System.out.println("please pass the right browser name...." + browserName);
                  throw new FrameworkException("No Browser Found...");
          }
         getDriver().manage().deleteAllCookies();
         getDriver().manage().window().maximize();
         getDriver().get(prop.getProperty("url"));

         return getDriver();


     }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
