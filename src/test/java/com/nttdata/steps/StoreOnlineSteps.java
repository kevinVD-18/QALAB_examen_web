package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class StoreOnlineSteps {
    private WebDriver driver;
    MyStorePage myStorePage;

    //constructor
    public StoreOnlineSteps(WebDriver driver){
        this.driver = driver;
    }

    public void validarLabelLogOut(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = driverWait.until(ExpectedConditions.visibilityOfElementLocated(myStorePage.btn_cerrar_sesion));
        Boolean isVisisble =  logout.isDisplayed();
        Assert.assertTrue(isVisisble);
    }

    public void seleccionarCategoriaSubcategoria(String categoria, String subcategoria) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(., '"+categoria+"')]")).click();
        List<WebElement> links = driver.findElements(myStorePage.a_subcategorias);

        for (WebElement link : links) {
            if (link.getText().equals(subcategoria)) {
                link.click();
                break;
            }
        }
    }

    public void agregarProductosAlCarrito(String cantidad){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(myStorePage.first_product));
        firstElement.click();

        WebElement inputCantidad = driver.findElement(myStorePage.input_cantidad);
        inputCantidad.sendKeys(Keys.DELETE);
        inputCantidad.sendKeys(cantidad);

        driver.findElement(myStorePage.btn_agregar_carrito).click();
    }
}
