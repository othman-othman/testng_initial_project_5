package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginPage;

public class TechGlobalLoginPageTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Login Form");
        techGlobalLoginPage = new TechGlobalLoginPage();

    }

    @Test(priority = 1, description = "Validate TechGlobal Login Form Card")
    public void LoginForm() {
        Assert.assertEquals(techGlobalLoginPage.heading.getText(), "Login Form");
        Assert.assertEquals(techGlobalLoginPage.UsernameText.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginPage.UsernameText.isDisplayed());
        Assert.assertEquals(techGlobalLoginPage.passwordText.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginPage.passwordBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginPage.forgotPasswordLink.isDisplayed());
    }

    @Test(priority = 2, description = "Validate TechGlobal Login Form card valid login")
    public void ValidLogin() {
        techGlobalLoginPage.UsernameBox.click();
        techGlobalLoginPage.UsernameBox.sendKeys("TechGlobal");
        techGlobalLoginPage.passwordBox.click();
        techGlobalLoginPage.passwordBox.sendKeys("Test1234");
        techGlobalLoginPage.loginButton.click();
        Assert.assertEquals(techGlobalLoginPage.loginSuccess.getText(), "You are logged in");
        Assert.assertTrue(techGlobalLoginPage.logoutButton.isDisplayed());
    }

    @Test(priority = 3, description =  "Validate TechGlobal Login Form card valid login and then logout")
    public void loginAndLogout() {
        techGlobalLoginPage.UsernameBox.click();
        techGlobalLoginPage.UsernameBox.sendKeys("TechGlobal");
        techGlobalLoginPage.passwordBox.click();
        techGlobalLoginPage.passwordBox.sendKeys("Test1234");
        techGlobalLoginPage.loginButton.click();
        techGlobalLoginPage.logoutButton.click();
        Assert.assertTrue(techGlobalLoginPage.loginButton.isDisplayed());
    }
    @Test(priority = 4, description = "Validate TechGlobal Login Form card Forgot Password? Link and Reset Password page")

    public void forgotPassword() {
        techGlobalLoginPage.forgotPasswordLink.click();
        Assert.assertTrue(techGlobalLoginPage.resetPasswordHeading.isDisplayed());
        Assert.assertEquals(techGlobalLoginPage.resetMessage.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(techGlobalLoginPage.resetPasswordEmailBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginPage.passwordSubmitButton.isDisplayed());
    }

    @Test(priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")

    public void validateFormCardResetPasswordLink() {
        techGlobalLoginPage.forgotPasswordLink.click();
        techGlobalLoginPage.resetPasswordEmailBox.sendKeys("samiryasin@gmail.com");
        techGlobalLoginPage.passwordSubmitButton.click();
        Assert.assertEquals(techGlobalLoginPage.conformationMessage.getText(),"A link to reset your password has been sent to your email address.");

    }
    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validateInvalidLoginWithWrongUsername(){
        techGlobalLoginPage.UsernameBox.sendKeys("john");
        techGlobalLoginPage.passwordBox.sendKeys("Test1234");
        techGlobalLoginPage.loginButton.click();
        Assert.assertEquals(techGlobalLoginPage.invalidCredentialsErrorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with wrong password")

    public void validateInvalidLoginWithWrongPassword() {
        techGlobalLoginPage.UsernameBox.click();
        techGlobalLoginPage.UsernameBox.sendKeys("TechGlobal");
        techGlobalLoginPage.passwordBox.click();
        techGlobalLoginPage.passwordBox.sendKeys("1234");
        techGlobalLoginPage.loginButton.click();
        Assert.assertEquals(techGlobalLoginPage.invalidCredentialsErrorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with both wrong credentials ")
    public void validateInvalidLoginWithWrongUsernameAndPassword(){
        techGlobalLoginPage.UsernameBox.click();
        techGlobalLoginPage.UsernameBox.sendKeys("John");
        techGlobalLoginPage.passwordBox.click();
        techGlobalLoginPage.passwordBox.sendKeys("1234");
        techGlobalLoginPage.loginButton.click();
        Assert.assertEquals(techGlobalLoginPage.invalidCredentialsErrorMessage.getText(), "Invalid Username entered!");
    }
}