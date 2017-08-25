package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SubmitArticle {
    @FindBy(xpath = ".//*[@id='jform_title']")
    private WebElement titleField;

    @FindBy(id = "tinymce")
    private WebElement textBox;

    @FindBy(xpath = ".//*[@id='editor-xtd-buttons']/a")
    private List<WebElement> optionsButtons;

    @FindBy(xpath = ".//*[@id='adminForm']/div/div[1]/button")
    private WebElement submitButton;

    @FindBy(xpath = "html/body/ul/li[3]/a/div[2]")
    private WebElement sampleImage;

    @FindBy(xpath = "html/body/ul/li[1]/a/div[2]")
    private WebElement fruitsImage;

    @FindBy(xpath = "html/body/ul/li[1]/a/div[1]/div")
    private WebElement appleImage;

    @FindBy(xpath = ".//*[@id='imageForm']/div[3]")
    private WebElement url;

    @FindBy(xpath = ".//*[@id='imageForm']/div[2]/div/div[2]/button[1]")
    private WebElement insertImage;

    @FindBy(id = "jform_articletext_ifr")
    private WebElement framee;

    @FindBy(xpath = ".//*[@id='mceu_67-body']/div")
    private List<WebElement> style;

    private WebDriver driver;

    public SubmitArticle(WebDriver driver){
        this.driver=driver;
    }
    public void addTitle(String title){
        titleField.clear();
        titleField.sendKeys(title);
    }
    public void addText(String text){
       driver.switchTo().frame(framee);
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.click();
        textBox.sendKeys(text);
        driver.switchTo().defaultContent();
        style.get(0).click();
        style.get(1).click();
        driver.switchTo().frame(framee);
        textBox.sendKeys(text);
        driver.switchTo().defaultContent();
        submitButton.click();
        Assert.assertEquals("Article submitted.",driver.findElement(By.xpath("//*[@id=\"system-message\"]/div/div/div")).getText());

    }
    public void addImage(){
        String baseWindow = driver.getWindowHandle();

        optionsButtons.get(4).click();
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='sbox-window']"))));
        driver.findElement(By.xpath(".//*[@id='sbox-window']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='sbox-content']/iframe"))));
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='sbox-content']/iframe")));
        //insertImage.click();
        //sampleImage.click();
        //fruitsImage.click();
        //appleImage.click();
        insertImage.click();
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().window(baseWindow);

    }
    public void submit(){
        //submitButton.click();
    }
}
