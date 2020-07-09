package company.name.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage{

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;

    @FindBy(className = "link-lk")
    private WebElement forgotPasswordButton;

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(className = "lk-enter-btn")
    private  WebElement logInButton;

    @FindBy(id = "logout")
    private WebElement logOutButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть тестовый стенд")
    public void testStandOpen(){
        DriverManager.getDriver().get(getTestStand());
        check("Проверяем активность кнопки 'Войти'",
                checkLoginButton(),
                "Open test stand exception");
    }
    @Step("Открыть окно для авторизации")
    public void openWindowAuthorization(){
        loginButton.click();
        check("Проверяем открытие окна авторизации",
                checkForgotPasswordButton(),
                "Open popUp exception");
    }
    @Step("Ввести email")
    public void inputEmail(String email){
        loginField.sendKeys(email);
        check("Проверяем правильность ввода email",
                checkLoginField(email),
                "Input email authorization exception");
    }
    @Step("Ввести password")
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
        check("Проверяем правильность ввода password",
                checkPasswordField(password),
                "Input password authorization exception");
    }
    @Step("Нажимаем кнопку Войти")
    public void clickLogIn(){
        logInButton.click();
        check("Проверяем активность кнопки 'Выйти'",
                checkLogOutButton(),
                "Client login exception");
    }
    @Step("Нажимаем кнопку Выйти")
    public void clickLogOut(){
        logOutButton.click();
        check("Проверяем активность кнопки Войти",
                checkLogInButton(),
                "Client LogOut exception");
    }

    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    public boolean checkForgotPasswordButton() {
        return forgotPasswordButton.isEnabled();
    }

    public boolean checkLoginField(String email) {
        return loginField.getAttribute("value").equals(email);
    }

    public boolean checkPasswordField(String password) {
        return passwordField.getAttribute("value").equals(password);
    }

    public boolean checkLogInButton() {
        return loginButton.isEnabled();
    }

    public boolean checkLogOutButton() {
        return logOutButton.isEnabled();
    }
}
