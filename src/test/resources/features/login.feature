@login
Feature: Login de usuarios

  @smoke @positive
  Scenario: Login exitoso con credenciales válidas
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "standard_user" y password "secret_sauce"
    Then debe visualizar el catálogo de productos

  @negative
  Scenario: Login con usuario inexistente
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "usuario_fake" y password "secret_sauce"
    Then deberia ver el mensaje "Epic sadface: Username and password do not match any user in this service"

  @negative
  Scenario: Login con password incorrecto
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "standard_user" y password "password_fake"
    Then deberia ver el mensaje "Epic sadface: Username and password do not match any user in this service"


  @negative
  Scenario: Login sin usuario
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "" y password "secret_sauce"
    Then deberia ver el mensaje "Epic sadface: Username is required"

  @negative
  Scenario: Login sin password
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "standard_user" y password ""
    Then deberia ver el mensaje "Epic sadface: Password is required"

  @negative
  Scenario: Login sin usuario ni password
    Given que el usuario se encuentra en la pantalla de login
    When inicia sesión con usuario "" y password ""
    Then deberia ver el mensaje "Epic sadface: Username is required"

