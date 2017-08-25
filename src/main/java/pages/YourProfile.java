package pages;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.image.Kernel;
import java.util.List;

public class YourProfile {

    @FindBy(id = "jform_params_editor")
    private WebElement OptionsField;

    @FindBy(xpath = ".//*[@id='jform_params_editor_chzn']/a/span")
    private WebElement OptionsFieldb;

    @FindBy(xpath = ".//*[@id='jform_name']")
    private WebElement nameField;

    @FindBy(xpath = ".//*[@id='member-profile']/div/div/button")
    private WebElement submitButton;


    @FindBy(xpath = ".//*[@id='jform_params_editor_chzn']/a")
    private WebElement dropDown;


    @FindBy(xpath = ".//*[@id='jform_params_timezone_chzn']/a")
    private WebElement timeZone;

    @FindBy(xpath = ".//*[@id='jform_params_timezone_chzn']/div/div/input")
    private WebElement timeZoneField;

    private WebDriver driver;
    public YourProfile(WebDriver driver) {
        this.driver = driver;
    }
    //public Integer number(){

    //return OptionsField.size();
    //}
    public void changeName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        submitButton.click();
    }

    public void selectOption(Integer i) {

//        OptionsFieldb.click();
//        Select dropdown=new Select(OptionsField);
//        dropdown.deselectAll();
//        dropdown.selectByVisibleText("V");
// OptionsFieldb.sendKeys(Keys.ARROW_DOWN);


        Select select = new Select(driver.findElement(By.id("jform_params_editor")));
        select.selectByValue("codemirror");
    }

    public void Editor(String timeZoneOption) {
        dropDown.click();
        timeZone.click();
        if (timeZoneField.isDisplayed()) {
            timeZoneField.sendKeys(timeZoneOption);
            timeZoneField.sendKeys(Keys.ENTER);
        }
        submitButton.click();
        Assert.assertEquals("Profile saved.",driver.findElement(By.xpath("//*[@id=\"system-message\"]/div/div/div")).getText());
    }
}
