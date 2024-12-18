package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarSteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.StoreOnlineSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreOnlineStepsDef {

    private WebDriver driver;
    int cantidadProducto;
    LoginSteps iniciarSesion = new LoginSteps(getDriver());
    StoreOnlineSteps storeOnlineSteps = new StoreOnlineSteps(getDriver());
    CarSteps carSteps = new CarSteps(getDriver());

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave( String usuario,  String password) {
        iniciarSesion.IniciarSesion(usuario, password);
        storeOnlineSteps.validarLabelLogOut();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) throws InterruptedException {
        storeOnlineSteps.seleccionarCategoriaSubcategoria(categoria, subcategoria);
        screenShot();
    }

    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        cantidadProducto = Integer.parseInt(cantidad);
        storeOnlineSteps.agregarProductosAlCarrito(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        carSteps.modalIsDisplayed();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        carSteps.validarValoresModal(cantidadProducto);
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        carSteps.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        carSteps.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        carSteps.validarPreciosCarrito(cantidadProducto);
        screenShot();
    }
}
