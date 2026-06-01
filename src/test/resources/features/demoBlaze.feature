@testAddProductCart
Feature: Escenario demo Blace


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




  @escenario_CriterioAc2
  Scenario Outline: Mostrar la información del producto seleccionado
    Given que el usuario se encuentra en la página principal
    When selecciona un "<producto>" de la categoria "<categoria>"
    Then debe visualizar la informacion correcta del producto
      | nombre      | <producto>    |
      | precio      | <precio>      |
      | descripcion | <descripcion> |

    Examples:
      | categoria | producto          | precio | descripcion |
      | Phones    | Samsung galaxy s6 | $360   | The Samsung Galaxy S6 is powered by        |
      | Laptops   | Sony vaio i5      | $790   | Sony is so confident that the VAIO S       |