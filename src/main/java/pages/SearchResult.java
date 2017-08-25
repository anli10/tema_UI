package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult {
    @FindBy(xpath = ".//*[@id='searchForm']/div[2]/p/strong/span")
    private WebElement totalResultsField;

    @FindBy(xpath = ".//*[@id='search-searchword']")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='searchphraseexact']")
    private WebElement  exactField;

    @FindBy(xpath = ".//*[@id='searchphraseany']")
    private WebElement anyField;

    @FindBy(xpath = ".//*[@id='searchphraseall']")
    private WebElement allField;

    private WebDriver webDriver;

    public SearchResult(WebDriver wedDriver){
        this.webDriver=webDriver;
    }

    public void CheckDislayed(){
        Assert.assertTrue(searchField.isDisplayed());
        Assert.assertTrue(allField.isDisplayed());
        Assert.assertTrue(anyField.isDisplayed());
        Assert.assertTrue(exactField.isDisplayed());

    }
    public Integer getTotalResults(){
        return Integer.valueOf(totalResultsField.getText());
    }

    public void setExact() {
        this.exactField.click();
    }

    public void allExact() {
        this.allField.click();
    }
    public void anyExact() {
        this.anyField.click();
    }
    public void search(String text){
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }

}
