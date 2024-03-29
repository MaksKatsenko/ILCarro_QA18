package tests;
import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test(dataProvider = "loginModelDto",dataProviderClass = ProviderData.class)
    public void loginPositiveTest(User data){
 //       User data = new User().withEmail("telran2022@gmail.com").withPassword("Ads$gf1288");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginPositiveTestConfig(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        User data = new User().withEmail("ran2018mail.com").withPassword("Ads$gf1288");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();

       Assert.assertTrue(app.getUser().isLoggedFailed());
    }




 @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
 }
}
