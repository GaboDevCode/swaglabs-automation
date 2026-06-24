@testProductCart
Feature: Carrito de compras en DemoBlaze
  Como cliente de DemoBlaze
  Quiero poder gestionar mi carrito de compras
  Para revisar y confirmar los productos antes de realizar una compra

  Background:
    Given que el usuario se encuentra en la página principal de DemoBlaze

  @escenario_CriterioAc1
  Scenario Outline: El producto agregado debe aparecer en el carrito
    Given el usuario navega a la categoría "<categoria>"
    And selecciona el producto "<producto>"
    When agrega el producto al carrito
    And navega al carrito
    Then debe visualizar el producto "<producto>" con precio <precio> en el carrito

    Examples:
      | producto          | categoria | precio |
      | Sony vaio i5      | Laptops   | 790    |
      | Samsung galaxy s6 | Phones    | 360    |


  @escenario_CriterioAc2

  Scenario: El total del carrito coincide con la suma de los productos

    Given que el usuario agrego los siguientes productos al carrito:
      | producto          | categoria | precio |
      | Sony vaio i5    | Laptops   |   790    |
      | Samsung galaxy s6 | Phones    | 360    |
    Then debe visualizar que la suma de los productos coincida con el total esperado "1150"


