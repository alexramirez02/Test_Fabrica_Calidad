package co.edu.udea.calidad.immnosistemas17.tasks;

import co.edu.udea.calidad.immnosistemas17.userinterfaces.PaginaEntregaUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EliminarDocumento {
    public static Task delSistema() {
        return Task.where("El usuario elimina el documento",
                Click.on(PaginaEntregaUI.BOTON_ELIMINAR)
        );
    }
}