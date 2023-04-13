import PageTests.DriverSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.commons.io.FileUtils;
import PageTests.eToroMoneyMainEN;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MainTest extends DriverSingleton {
    private static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("eToro Money Marketing - Automation test", "QA Automation test for eToro Money Marketing material - a maven based Automation project using Selenium JAVA");

    @BeforeClass
    public void runBeforeClass() throws Exception{
        // creating a new report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Class 14\\TestSys");

        extent.attachReporter(htmlReporter);
        test.log(Status.INFO,"driver invoked");
        //Driver is initiated here
        this.driver = DriverSingleton.getDriverInstance();

        //Set a wait comment to let the page load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        //Gets the url from Data.xml file using the "getData" method
        driver.get(getData("URL"));
        test.log(Status.INFO, "Go to first page (based on the DATA.xml file)");
    }

    @org.testng.annotations.Test

    public void test_01() throws Exception {
        test.log(Status.INFO, "Regression test for eTM page start");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        eToroMoneyMainEN eToroMoneyMainEN1 = new eToroMoneyMainEN();
        try {
            eToroMoneyMainEN1.assertTitleTest();
            test.log(Status.PASS, "Meta title asserted");
            eToroMoneyMainEN1.testCTAButton();
            test.log(Status.PASS, "CTA test passed");

        }catch (Exception e){
            test.log(Status.FAIL, "a step on the test failed");
        }

    }



    @AfterClass
    public void afterClass(){
        driver.quit();
        extent.flush();
    }

    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }





}
