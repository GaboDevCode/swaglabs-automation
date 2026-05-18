@testInventory
Feature: Visualizar productos del catálogo

  @testProductInventory
  Scenario: Visualizar detalle de un producto

    Given que el usuario está en la pantalla de inventario
    When selecciona un producto
    Then debe visualizar el detalle del producto
