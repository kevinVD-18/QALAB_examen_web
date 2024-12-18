package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;
    LoginPage loginPage;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void IniciarSesion(String username, String password){
        WebElement btnIniciarSesion = driver.findElement(loginPage.button_iniciar_sesion);
        btnIniciarSesion.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement inputUsername = driver.findElement(loginPage.input_username);
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(loginPage.input_password);
        inputPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(loginPage.button_login);
        btnLogin.click();
    }

}
