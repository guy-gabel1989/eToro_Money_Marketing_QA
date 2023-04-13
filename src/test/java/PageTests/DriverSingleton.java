package PageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;
    public void getData(){
        getData();
    }
    public static WebDriver getDriverInstance() throws Exception{

        if (driver == null){
            String browser = getData("browserType");
            switch (browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                case "FF":
                    System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
            }

        }
        return driver;

    }
    public static String getData(String keyName) throws Exception{
        File fXmlFile = new File("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Class 14\\TestSys\\src\\main\\resources\\Data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}
