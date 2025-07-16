Feature: Gestion de documentos

  Scenario: Subir un documento
    Given el usuario esta en la pagina de gestion de documentos
    When el usuario selecciona "Inteligencia Artificial" y sube el documento "archivo.pdf" con el nombre "exitoso"
    Then el documento "exitoso" aparece en la lista