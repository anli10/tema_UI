import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePageBeforeLogIn;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestBaseClass {
    protected static HomePageBeforeLogIn homePageBeforeLogIn;
    private  static WebDriver webDriver;

    @BeforeClass
    public static void before(){

        System.setProperty("webdriver.chrome.driver","C:/Users/bghiuta/Documents/My Received Files/chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.get("http://192.168.167.136:81/joomla/");
        homePageBeforeLogIn = PageFactory.initElements(webDriver, HomePageBeforeLogIn.class);
    }

    @AfterClass
    public static void after(){
        //webDriver.close();
    }
}
