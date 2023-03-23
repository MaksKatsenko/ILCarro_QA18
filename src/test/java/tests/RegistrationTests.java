package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
//@BeforeMethod


    @Test
    public void registrationPositiveTest(){

        int i = (int)((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "@mail.com")
                .withPassword("$44Dsd97Tre"+ i);

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckbox();
        app.getUser().submitForm();
    }
}
