package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath=".//*[@id='top']/div/nav/div[2]/ul/li/a")
    private WebElement homeButton;

    @FindBy(xpath=".//div[@id='top']/div/header/div/a/span")
    private WebElement header;

    @FindBy(xpath=".//*[@id='login-form']/div[2]/input[1]")
    private WebElement logOut;

    @FindBy(xpath=".//*[@id='aside']/div[1]")
    private WebElement popularTagBox;

    @FindBy(xpath=".//*[@id='aside']/div[1]/div/ul/li")
    private WebElement getPopularTagContainer;

    @FindBy(xpath=".//*[@id='aside']/div[3]")
    private WebElement userMenu;

    @FindBy(xpath=".//*[@id='aside']/div[3]/ul/li[1]/a")
    private WebElement yourProfileButton;

    @FindBy(xpath=".//*[@id='aside']/div[3]/ul/li[2]/a")
    private WebElement submitArticleButton;

    @FindBy(xpath=".//*[@id='aside']/div[3]/ul/li[3]/a")
    private WebElement siteAdmin;

    @FindBy(xpath=".//*[@id='aside']/div[3]/ul/li[4]/a")
    private WebElement templateSet;

    @FindBy(xpath=".//*[@id='aside']/div[3]/ul/li[5]/a")
    private WebElement siteSet;

    @FindBy(xpath=".//*[@id='mod-search-searchword93']")
    private WebElement searchBox;

    private WebDriver webDriver;

    public HomePage(WebDriver driver){
        this.webDriver=driver;
    }

    public void checkDispayed(){
        Assert.assertTrue(yourProfileButton.isDisplayed());
        Assert.assertTrue(submitArticleButton.isDisplayed());
        Assert.assertTrue(siteAdmin.isDisplayed());
        Assert.assertTrue(templateSet.isDisplayed());
        Assert.assertTrue(siteSet.isDisplayed());
        Assert.assertTrue((searchBox.isDisplayed()));
    }

    public void checkHeader(String head){
        Assert.assertEquals(header.getText(),head);
    }
    public void checkPopularTags(String tag){
        Assert.assertTrue(popularTagBox.isDisplayed());
        Assert.assertTrue(tag.contains(getPopularTagContainer.getText()));
        Assert.assertTrue(userMenu.isDisplayed());
    }
    public SearchResult searchText(String text){
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver,SearchResult.class);
    }
    public void logOut(){
        logOut.click();
    }

    public YourProfile accessYourProfile(){
        yourProfileButton.click();
        return PageFactory.initElements(webDriver,YourProfile.class);
    }
    public SubmitArticle accessSubmitArticle(){
        submitArticleButton.click();
        return PageFactory.initElements(webDriver,SubmitArticle.class);
    }
    public SiteAdmin accessSiteAdmin(){
        siteAdmin.click();
        return PageFactory.initElements(webDriver,SiteAdmin.class);
    }
    public TemplateSet accessTemplateSet(){
        templateSet.click();
        return PageFactory.initElements(webDriver,TemplateSet.class);
    }
    public void waitUntil(){
        WebDriverWait wait=new WebDriverWait(webDriver,3000);
        wait.until(ExpectedConditions.textToBePresentInElement(header,""));

    }

}
