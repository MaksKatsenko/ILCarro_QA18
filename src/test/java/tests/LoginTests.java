package tests;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        User data = new User().withEmail("telran2022@gmail.com").withPassword("Ads$gf1288");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
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
