@testLogin
Feature: Login de usuarios


  @testLoginExitoso
  Scenario: Login exitoso con credenciales válidas
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "standard_user" y password "secret_sauce"
    Then debe visualizar el catálogo de productos