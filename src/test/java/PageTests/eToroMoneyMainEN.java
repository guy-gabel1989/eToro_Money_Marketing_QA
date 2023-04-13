package PageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class eToroMoneyMainEN extends BasePage{


    public void assertTitleTest() throws Exception {
        assertTitle();
    }

    public void testCTAButton()throws Exception{
        testCTA();
    }

    public void testFooter() throws Exception{

    }


    private void assertTitle() throws Exception{

        //Assert page Meta title
        String expectedTitle = "eToro Money: Intelligently manage your eToro investment account";
        String actualTitle = getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    private void testCTA() throws Exception{
// test if the CTA is visible
        boolean present;
        try {
            findElement(LOCATOR_CTA);
            present = true;
        }catch (NoSuchElementException e){
            present = false;
        }
        System.out.println(present);

        String actualCTALink =  getLink(LOCATOR_CTA);
        String expectedCTALink = "https://www.etoro.com/payments/create-money-account?isEtoroMoneyAccount=1";
        Assert.assertEquals(actualCTALink, expectedCTALink);
        System.out.println(actualCTALink);

    }

    private void testPageFooter()throws Exception{
        

    }

    public static final By LOCATOR_CTA = By.xpath("(//a[@class='e-cta money2mix'])[1]");


}
