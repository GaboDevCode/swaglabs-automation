@testDetailProduct
Feature: Visualización de detalles del producto

@escenario_CriterioAc2
Scenario Outline: Mostrar la información del producto seleccionado
Given que el usuario se encuentra en la página principal
When selecciona un "<producto>" de la categoria "<categoria>"
Then debe visualizar la informacion correcta del producto
| nombre      | <producto>    |
| precio      | <precio>      |
| descripcion | <descripcion> |

Examples:
| categoria | producto          | precio | descripcion                          |
| Phones    | Samsung galaxy s6 | $360   | The Samsung Galaxy S6 is powered by  |
| Laptops   | Sony vaio i5      | $790   | Sony is so confident that the VAIO S |