package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    String correctEmail = "telran2022@gmail.com";
    String correctPassword = "Ads$gf1288";
    String IncorrectEmail = "ran2018mail.com";
    String IncorrectPassword = "ds1288";

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(correctEmail, correctPassword);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void loginNegativeTestWrongEmail(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(IncorrectEmail, correctPassword);
        app.getUser().submitForm();

       Assert.assertTrue(app.getUser().isLoggedFailed());
    }




 @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
 }
}
