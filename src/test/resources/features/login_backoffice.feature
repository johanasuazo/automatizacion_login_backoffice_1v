#Autor:johana.giraldo@konexinnovation.com.co

  @HULOGIN
  Feature: verificar el login con diferentes usuarios
    Yo como usuario
  Quiero ingresar a la pagina color
  Para verificar el inicio de sesion con diferentes usuarios

  @Caso1
   Scenario Outline: Verificar el ingreso corrrecto con un usuario
    Given que el usuario ingresa al Backoffice
    When digita usuario y contrasenna del usuario
      | usuario   | contrasenna   |
      | <usuario> | <contrasenna> |
    Then verifica el ingreso correcto

    Examples:
      | usuario     | contrasenna |
      | 10974074491 | JGIRALDO10  |

    @Caso2
  Scenario Outline: Verificar el ingreso correcto con diferentes usuarios
    Given que el usuario ingresa al Backoffice
    When digita usuario y contrasenna del usuario
      | usuario   | contrasenna   |
      | <usuario> | <contrasenna> |
    Then verifica que ingreso correctamente

    Examples:
      | usuario     | contrasenna   |
      | 10974074491 | JGIRALDO10    |
      | 10101012    | ADATACENTER10 |
      | 10101013    | CDATACENTER10 |


@Caso3
  Scenario Outline: Verificar el ingreso con credenciales incorrectas
  Given que el usuario ingresa al Backoffice
  When digita usuario o contrasenna incorrectas
    | usuario   | contrasenna   |
    | <usuario> | <contrasenna> |
  Then verifica el mensaje de error

  Examples:
    | usuario     | contrasenna   |
    | 10974074491 | ADATACENTER10 |
    | 10101022    | CLAVE         |
    | USER        | CLAVEERRADA   |

  