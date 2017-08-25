package pages;

import com.thoughtworks.selenium.BrowserConfigurationOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.login.Configuration;
import java.util.List;

public class SiteAdmin {

    @FindBy(xpath = ".//*[@id='mod-login-username']")
    private WebElement userField;

    @FindBy(xpath = ".//*[@id='mod-login-password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='content']/div/div/div[2]/div[1]/div/div/div/ul[4]/li/a/span[2]")
    private List<WebElement> configurationOptions;

   @FindBy(css = ".badge.badge-info.hasTooltip")
    private WebElement hits;

    @FindBy(xpath = ".//*[@id='form-login']/fieldset/div[4]/div/div/button")
    private WebElement logInButton;

    private WebDriver driver;

    public void logIn(String user ,String password){
        userField.sendKeys(user);
        passwordField.sendKeys(password);
        logInButton.click();
    }
    public SiteAdmin(WebDriver driver){
        this.driver=driver;
    }
    public void editConfiguration(){
        for (int i=0;i<configurationOptions.size();i++) {
            WebDriverWait wait = new WebDriverWait(driver,4);
            configurationOptions.get(i).click();
            driver.findElement(By.xpath(".//*[@id='jform_sitename']")).clear();
            driver.findElement(By.xpath(".//*[@id='jform_sitename']")).sendKeys("bghiuta's site");
            driver.findElement(By.xpath(".//*[@id='jform_sef_rewrite']/label[1]")).click();
        }
    }
    public void checkHits(){
        Assert.assertTrue(hits.getText().startsWith("3"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
        js.executeScript("window.history.go(-1)");
    }
}
