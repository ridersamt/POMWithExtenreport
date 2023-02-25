package Testcase;

import Objects.BasicUtils;
import Objects.Beforeclassinvoke;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    BasicUtils bu=new BasicUtils();
    WebDriver driver;
    Beforeclassinvoke bi=new Beforeclassinvoke(driver);

    public TestLogin(String BaseURL)
    {
        System.out.println("This is constructor BaseURL");
        this.bu.BaseURL=BaseURL;
    }

    @BeforeTest
    public void Beforetest()
    {
        bi.Extenreportstart("Login test");
        bi.setupChrome();
        driver= bi.navigate(bu.GoogleURL);
    }
    @Test
    public void Login() {

        //  Assert.assertEquals("My Account",driver.getTitle());
        if (driver.getTitle().equals("Google")) {
            bi.test.log(LogStatus.PASS, "Navigated to the specified URL Google.com");

        } else {
            //  Assert.assertEquals("My Account",driver.getTitle());
            bi.test.log(LogStatus.FAIL, "Test Failed actual title is "+driver.getTitle());
        }
    }

    @AfterTest
    public void Aftermethod()
    {
        bi.endTest();
        bi.closedriver();
        System.out.println(System.getProperty("user.dir")+"\\testReport.html");
    }
}
