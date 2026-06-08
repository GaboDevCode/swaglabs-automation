@testAddProductCart
Feature: Escenario demo Blace


#Al ingresar al home de demoblaze deben poder visualizarse las categorías de: Phones, Laptops y Monitors.
#Cada categoría debe mostrar como mínimo 2 productos.
#Cada categoría debe mostrar como máximo 6 productos
#El título de la pestaña debe ser “STORE”
#Al Hacer click sobre un producto, el sitio debe llevarnos a la ficha de ese producto

  @escenario_CriterioAc1
  Scenario Outline: Visualizar categorías de productos en el home
    Given que el usuario se encuentra en la página principal
    When el usuario selecciona una "<categoria>"
    Then debe visualizar al menos <cantidad_minima> productos

    Examples:
      | categoria | cantidad_minima |
      | Phones    | 2               |
      | Laptops   | 2               |
      | Monitors  | 2               |


