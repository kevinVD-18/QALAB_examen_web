package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyStorePage {
    public static By btn_cerrar_sesion = By.xpath("//a[contains(text(), 'Cerrar sesión')]");
    public static  By li_categorias =  By.xpath("//a[@class='dropdown-item']");
    public static  By a_subcategorias = By.xpath("//ul[@class='category-sub-menu']//a");
    public static  By first_product = By.xpath("(//div[@id='js-product-list']/div/div/article)[1]");
    public static By input_cantidad = By.id("quantity_wanted");
    public static By btn_agregar_carrito = By.xpath("//button[@data-button-action='add-to-cart']");

}
