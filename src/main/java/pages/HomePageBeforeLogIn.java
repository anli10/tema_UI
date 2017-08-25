package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBeforeLogIn {

    @FindBy(id="modlgn-username")
    private WebElement logInFormUser;

    @FindBy(id="modlgn-passwd")
    private WebElement logInFormPassword;

    @FindBy(xpath=".//*[@id='form-login-submit']/div/button")
    private WebElement logInFormButton;

//   @FindBy(id="modlgn-passwd")
//    private WebElement logInFormPassword;

    private WebDriver webDriver;

    public HomePageBeforeLogIn(WebDriver driver){
        this.webDriver=driver;
    }

    public HomePage logIn(String username, String password){

        logInFormUser.sendKeys(username);
        logInFormPassword.sendKeys(password);
        logInFormButton.click();

        HomePage homePage= PageFactory.initElements(webDriver,HomePage.class);
        return homePage;
    }

}
