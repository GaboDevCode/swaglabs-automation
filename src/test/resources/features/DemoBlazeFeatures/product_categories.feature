@testProductCategories
Feature: Visualización de categorías de productos

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