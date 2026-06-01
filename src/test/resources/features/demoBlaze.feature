@testAddProductCart
Feature: Escenario demo Blace


#Al ingresar al home de demoblaze deben poder visualizarse las categorías de: Phones, Laptops y Monitors.
#Cada categoría debe mostrar como mínimo 2 productos.
#Cada categoría debe mostrar como máximo 6 productos
#El título de la pestaña debe ser “STORE”
#Al Hacer click sobre un producto, el sitio debe llevarnos a la ficha de ese producto

  @escenario_n1
  Scenario: Visualizar categorías de productos
    Given que el usuario se encuentra en la página principal de "https://www.demoblaze.com"
    Then debe visualizar la categoria "Phones"
