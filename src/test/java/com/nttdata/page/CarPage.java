package com.nttdata.page;

import org.openqa.selenium.By;

public class CarPage {

    public static By titulo_modal = By.xpath("//h4[@id='myModalLabel']");
    public  static  By lbl_precio_modal = By.xpath("//p[@class='product-price']");
    public  static  By lbl_total_modal = By.xpath("//p[@class='product-total']//span[@class='value']");
    public  static By btn_finalizar_compra = By.xpath("//div[@class='cart-content-btn']/a");
    public static By lbl_titulo_carrito = By.xpath("//div[@class='card cart-container']/div/h1");

    public static By lbl_precio_carrito = By.xpath("//span[@class='price']");
    public static By lbl_precio_total_carrito = By.xpath("//span[@class='product-price']");
    public static By lbl_precio_total_impuesto = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
    public double convertText(String valor){
        return Double.parseDouble(valor.replaceAll("[^0-9.]", ""));
    }

}
