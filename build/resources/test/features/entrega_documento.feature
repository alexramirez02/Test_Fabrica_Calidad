Feature: Se puede acceder al aplicativo de entrega

  Scenario: Entregar un documento
    Given el usuario se sitúa en el aplicativo para seleccionar el tipo de documento
    When envía el formulario de entrega
    Then debe visualizarse la entrega del documento

  Scenario: Eliminar un documento
    Given el usuario se sitúa en el aplicativo
    When elimina el documento cargado
    Then debe visualizarse la eliminación del documento