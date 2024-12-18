package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By button_iniciar_sesion = By.xpath("//div[@class='user-info']/a");
    public static  By input_username = By.name("email");
    public static By input_password = By.name("password");
    public static By button_login = By.id("submit-login");

}
