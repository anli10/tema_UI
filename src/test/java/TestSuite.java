import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Properties;

public class TestSuite extends TestBaseClass{

   String read(String key) {
       try {
           File file = new File("data.properties");
           FileInputStream fileInput = new FileInputStream(file);
           Properties properties = new Properties();
           properties.load(fileInput);
           fileInput.close();

           //Enumeration enuKeys = properties.keys();
           String value = properties.getProperty(key);
           return value;
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    //Log in test: inserting credentials
    @Test
    public void logInTest(){

        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        homePage.logOut();
    }

    //After Log in check if elements are displayed on the page
    @Test
    public void presenceOfElementsTest(){

        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        homePage.checkHeader(read("sitename"));
        homePage.checkPopularTags(read("site"));
        homePage.checkDispayed();
        homePage.logOut();
    }
    //After log in, search for an existing article, check if the number of results is 1, then search for an article that can't be
    //found by selecting "ExactPhrase" option,check if the number of results is 0
    @Test
    public void searchTextTest(){
        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        SearchResult searchResult=homePage.searchText("getting");
        Assert.assertEquals((Integer)1,searchResult.getTotalResults());
        searchResult.search("getting t"+randomString(2));
        searchResult.setExact();
        Assert.assertEquals((Integer)0,searchResult.getTotalResults());
        homePage.logOut();
    }

    //After log in, edit the time-zone field found in Your Profile, click Submit and check if profile is saved
    @Test
    public void  EditProfileTest(){
        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        YourProfile yourProfile=homePage.accessYourProfile();
        yourProfile.changeName(randomString(5));
        yourProfile.Editor(read("timezone"));
        //yourProfile.selectOption(0);
        //System.out.println(yourProfile.number());
        homePage.logOut();

    }
    // Submit a new article by accessing the menu option: Submit Article
    @Test
    public void  SubmitArticle(){

        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
         SubmitArticle submitArticle=homePage.accessSubmitArticle();
         submitArticle.addTitle("Titlul1"+randomString(3));
         submitArticle.addText("Text1"+randomString(30));
         submitArticle.submit();

         homePage.logOut();

    }

    // Click on Site Administration and check if the number of hits for the article "Getting started"
    // starts with "3"
    @Test
    public void  SiteAdministrator(){
        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        SiteAdmin siteAdmin=homePage.accessSiteAdmin();
        siteAdmin.logIn(read("username"),read("password"));
        //submitArticle.editConfiguration();
        siteAdmin.checkHits();
        homePage.logOut();
    }

    //Change the colors,title and description and save setting
    @Test
    public void  TemplateSet(){
        HomePage homePage = homePageBeforeLogIn.logIn(read("username"),read("password"));
        TemplateSet templateSet=homePage.accessTemplateSet();
        templateSet.SetColor();
        templateSet.setTitle("title "+randomString(3));
        templateSet.setDescription("description " +randomString(10));
       homePage.logOut();
    }

}
