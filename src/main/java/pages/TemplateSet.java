package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplateSet {

    @FindBy(xpath = ".//*[@id='params_templateColor']")
    private WebElement templateColor;

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[1]/div[2]/div/div/div[3]/div[1]")
    private WebElement colorBox;

    @FindBy(xpath = ".//*[@id='params_templateBackgroundColor']")
    private WebElement backgroundColor;

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[2]/div[2]/div/div/div[3]/div[1]")
    private WebElement outside;
    //*[@id="page-site"]/div/fieldset
    @FindBy(xpath = ".//*[@id='params_sitetitle']")
    private WebElement titleField;

    @FindBy(xpath = ".//*[@id='params_sitedescription']")
    private WebElement descriptionField;

    @FindBy(xpath = ".//*[@id='templates-form']/div/div[1]/div[1]/button")
    private WebElement saveButton;

    private WebDriver driver;
    public TemplateSet(WebDriver driver) {
        this.driver = driver;
    }

    public void SetColor(){
        templateColor.click();
        templateColor.sendKeys("#31adde");
        colorBox.click();

        backgroundColor.click();
        backgroundColor.clear();
        backgroundColor.sendKeys("#484a85");

    }

    public void setTitle(String title){
        titleField.clear();
        titleField.sendKeys(title);

    }
    public void setDescription(String description){
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }
    public void saveChanges(){

        saveButton.click();
    }

}
