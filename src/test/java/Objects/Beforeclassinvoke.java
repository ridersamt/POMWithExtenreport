package Objects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Beforeclassinvoke {
    BasicUtils bu=new BasicUtils();
    public  ExtentTest test;
    public  ExtentReports report;
    WebDriver driver;


    public Beforeclassinvoke(WebDriver driver)
    {
        System.out.println("Constructor call 1 arg");
        this.driver=driver;

    }

    public Beforeclassinvoke(ExtentTest test, ExtentReports report)
    {
        this.test=test;
        this.report=report;
    }

    public void setupChrome()
    {
        System.out.println("Setup chrome");
        driver= new ChromeDriver();

    }

    public WebDriver navigate(String basicUtils)
    {
        driver.get(basicUtils);
        return driver;
    }
    public  void Extenreportstart(String Testname) {
        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport"+System.currentTimeMillis()+".html");
        test = report.startTest(Testname);
    }

    @Test
    public void Testcall()
    {
        System.out.println("This is test call");
    }



    public  void endTest() {
        report.endTest(test);
        report.flush();
    }

    @BeforeClass
    public void bforeclass()
    {
        System.out.println("Before class");
        Extenreportstart("Demo");
        driver= new ChromeDriver();
        driver.get(bu.BaseURL);
    }


    public void closedriver()
    {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public void afterclass()
    {
        System.out.println("After class");
        endTest();
        closedriver();
    }
}
