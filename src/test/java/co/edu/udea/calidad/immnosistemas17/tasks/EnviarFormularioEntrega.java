package co.edu.udea.calidad.immnosistemas17.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Paths;

import static co.edu.udea.calidad.immnosistemas17.userinterfaces.PaginaEntregaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EnviarFormularioEntrega implements Task {

    private final String archivo;
    private final String nombre;

    public EnviarFormularioEntrega(String archivo, String nombre) {
        this.archivo = archivo;
        this.nombre = nombre;
    }

    public static EnviarFormularioEntrega conArchivoYNombre(String archivo, String nombre) {
        return new EnviarFormularioEntrega(archivo, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SELEC_TIPO_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SELEC_TIPO_DOCUMENTO),

                WaitUntil.the(OPTCON_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(OPTCON_DOCUMENTO),

                WaitUntil.the(RENGLON_NOMBRE_ARCHIVO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(RENGLON_NOMBRE_ARCHIVO),

                WaitUntil.the(SUBIR_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds(),
                Upload.theFile(Paths.get("src/test/resources/files/" + archivo)).to(SUBIR_DOCUMENTO),

                WaitUntil.the(BOTON_ENVIAR, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BOTON_ENVIAR)
        );
    }
}
