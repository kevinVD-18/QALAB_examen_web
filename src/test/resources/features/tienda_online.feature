@TestTienda
Feature: Product - Store

  Scenario Outline: Validación del precio de un producto
  Given estoy en la página de la tienda
  And me logueo con mi usuario "<usuario>" y clave "<clave>"
  When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
  And agrego "<cantidad>" unidades del primer producto al carrito
  Then valido en el popup la confirmación del producto agregado
  And valido en el popup que el monto total sea calculado correctamente
  When finalizo la compra
  Then valido el titulo de la pagina del carrito
  And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario                       | clave         | categoria | subcategoria | cantidad |
      | kevinvalenciadiaz18@gmail.com | 12345.kevin   | Clothes   | Men          | 2        |
      | kevinvalenciadiaz18@gmail.com | 12345.kevin12 | Clothes   | Men          | 2        |
      | kevinvalenciadiaz18@gmail.com | 12345.kevin   | Demo      | Men          | 2        |
