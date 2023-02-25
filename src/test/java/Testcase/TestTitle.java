package Testcase;

import Objects.BasicUtils;
import Objects.Beforeclassinvoke;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestTitle {
    BasicUtils bu=new BasicUtils();
    ExtentTest test;
    ExtentReports report;
    Beforeclassinvoke bi=new Beforeclassinvoke(test, report);
    WebDriver driver;

    @BeforeTest
    public void Beforetest()
    {
        bi.Extenreportstart("Title test");
        bi.setupChrome();
        driver = bi.navigate(bu.BaseURL);
    }

    @Test
    public void extentReportsDemo() {
        if (driver.getTitle().equals("Account Login")) {
            bi.test.log(LogStatus.PASS, "Navigated to the specified URL "+driver.getTitle());
        } else {
            bi.test.log(LogStatus.FAIL, "Test Failed "+driver.getTitle());
        }
    }

    @Test
    public void Testcase2() {
    //    Assert.assertEquals(driver.getTitle(),"My Account");

        if (driver.getTitle().equals("My Account")) {
            bi.test.log(LogStatus.PASS, "Navigated to the specified URL "+driver.getTitle());
        } else {

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
