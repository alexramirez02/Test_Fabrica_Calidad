package co.edu.udea.calidad.immnosistemas17.stepdefinitions;

import co.edu.udea.calidad.immnosistemas17.questions.DocumentoVisible;
import co.edu.udea.calidad.immnosistemas17.tasks.EliminarDocumento;
import co.edu.udea.calidad.immnosistemas17.tasks.EnviarFormularioEntrega;
import co.edu.udea.calidad.immnosistemas17.tasks.IngresarAplicativo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Managed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EntregaDocumentoStepDefinitions {

    @Managed
    WebDriver driver;

    Actor usuario = Actor.named("Usuario");

    @Dado("el usuario se sitúa en el aplicativo para seleccionar el tipo de documento")
    public void situarseEnElAplicativo() {
        usuario.can(BrowseTheWeb.with(driver));
        usuario.attemptsTo(IngresarAplicativo.enLaPagina());
    }

    @Cuando("envía el formulario de entrega")
    public void enviarFormulario() {
        usuario.attemptsTo(EnviarFormularioEntrega.conDocumento());
    }

    @Entonces("debe visualizarse la entrega del documento")
    public void validarEntrega() {
        boolean documentoVisible = DocumentoVisible.enPantalla().answeredBy(usuario);
        assertThat(documentoVisible, is(true));
    }

    @Cuando("elimina el documento cargado")
    public void eliminarDocumento() {
        usuario.attemptsTo(EliminarDocumento.delSistema());
    }

    @Entonces("debe visualizarse la eliminación del documento")
    public void validarEliminacion() {
        boolean documentoVisible = DocumentoVisible.enPantalla().answeredBy(usuario);
        assertThat(documentoVisible, is(false));
    }
}
