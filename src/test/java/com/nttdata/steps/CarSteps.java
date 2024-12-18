package com.nttdata.steps;

import com.nttdata.page.CarPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarSteps {
    private WebDriver driver;
    CarPage carPage = new CarPage();

    //constructor
    public CarSteps(WebDriver driver){
        this.driver = driver;
    }

    public void modalIsDisplayed(){

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = driverWait.until(ExpectedConditions.visibilityOfElementLocated(CarPage.titulo_modal));
        Boolean isVisisble =  logout.isDisplayed();
        Assert.assertTrue(isVisisble);
    }

    public void validarValoresModal(int cantidad){
        double precio = carPage.convertText(driver.findElement(carPage.lbl_precio_modal).getText());
        double precio_total = carPage.convertText(driver.findElement(carPage.lbl_total_modal).getText());
        double delta = 0.01;

        //Validación
        Assert.assertEquals("Validando el total",precio_total, precio * cantidad, delta);
    }


    public void finalizarCompra(){
        driver.findElement(carPage.btn_finalizar_compra).click();
    }

    public void validarTituloCarrito(){
        String tituloCarrito = driver.findElement(carPage.lbl_titulo_carrito).getText();
        Assert.assertEquals("CARRITO", tituloCarrito);
    }

    public void validarPreciosCarrito(int cantidadProducto) {
        double precio = carPage.convertText(driver.findElement(carPage.lbl_precio_carrito).getText());
        double precio_total = carPage.convertText(driver.findElement(carPage.lbl_precio_total_carrito).getText());
        double precio_total_impuesto = carPage.convertText(driver.findElement(carPage.lbl_precio_total_impuesto).getText());

        double delta = 0.01;

        //Validación
        Assert.assertEquals("Validando el total",precio_total, precio * cantidadProducto, delta);
        Assert.assertEquals("Validando el total con impuesto",precio_total_impuesto, precio * cantidadProducto, delta);
    }
}
