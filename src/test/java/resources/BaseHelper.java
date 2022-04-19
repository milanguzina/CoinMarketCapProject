package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseHelper {

     public static  WebDriver driver;

      public WebDriver initializeDriver () throws IOException {
      Properties prop = new Properties();
      FileInputStream fis = new FileInputStream("C:\\Users\\MicaiCora\\AutomationProjects\\CoinMarketCapProject\\src\\test\\java\\resources\\data.properties");

      prop.load(fis);
      String browserName = prop.getProperty("browser");

      if(browserName.contains("chrome"))
      {
          System.setProperty("webdriver.chrome.driver","C:\\Users\\MicaiCora\\AutomationProjects\\CoinMarketCapProject\\chromedriver.exe");
          ChromeOptions options = new ChromeOptions();
          if(browserName.contains("headless"))
          options.addArguments("headless");
          driver= new ChromeDriver(options);
      }
      else if (browserName.equals("firefox"))
      {
          System.setProperty("webdriver.gecko.driver","C:\\Users\\MicaiCora\\AutomationProjects\\CoinMarketCapProject\\geckodriver.exe");
          ChromeOptions options = new ChromeOptions();
          if(browserName.contains("headless"))
              options.addArguments("headless");
          driver= new FirefoxDriver();
      }
      else if (browserName.equals("IE"))
      {
          System.setProperty("webdriver.IEDriver.driver","C:\\Users\\MicaiCora\\AutomationProjects\\CoinMarketCapProject\\IEDriver.exe");
          ChromeOptions options = new ChromeOptions();
          if(browserName.contains("headless"))
              options.addArguments("headless");
          driver= new InternetExplorerDriver();
      }

      return driver;
  }
}
