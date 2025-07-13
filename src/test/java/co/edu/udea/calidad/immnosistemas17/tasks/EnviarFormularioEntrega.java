package co.edu.udea.calidad.immnosistemas17.tasks;

import co.edu.udea.calidad.immnosistemas17.userinterfaces.PaginaEntregaUI;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;

import java.nio.file.Paths;

public class EnviarFormularioEntrega {
    public static Task conDocumento() {
        return Task.where("El usuario llena y envía el formulario",
                Click.on(PaginaEntregaUI.SELECT_TIPO_DOCUMENTO),
                Click.on(PaginaEntregaUI.OPTION_DOCUMENTO),
                Upload.theFile(Paths.get("src/test/resources/files/ejemplo.pdf")).to(PaginaEntregaUI.INPUT_DOCUMENTO),
                Click.on(PaginaEntregaUI.BOTON_ENVIAR)
        );
    }
}