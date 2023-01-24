package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.TechGlobalBase;

public class TechGlobalLoginPage extends TechGlobalBase {
    public TechGlobalLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "main_heading")
    public WebElement heading;

    @FindBy(css = "label[for=\"username\"]")
    public WebElement UsernameText;

    @FindBy(id = "username")
    public WebElement UsernameBox;

    @FindBy(css = "label[for=\"password\"]")
    public WebElement passwordText;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "success_lgn")
    public WebElement loginSuccess;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordHeading;

    @FindBy(css = "label[for=\"email\"]")
    public WebElement resetMessage;

    @FindBy(id = "email")
    public WebElement resetPasswordEmailBox;

    @FindBy(id = "submit")
    public WebElement passwordSubmitButton;

    @FindBy(id = "confirmation_message")
    public WebElement conformationMessage;

    @FindBy(id = "error_message")
    public WebElement invalidCredentialsErrorMessage;
}