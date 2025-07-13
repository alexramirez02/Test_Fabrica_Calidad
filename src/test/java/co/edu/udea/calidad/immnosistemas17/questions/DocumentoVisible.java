package co.edu.udea.calidad.immnosistemas17.questions;

import co.edu.udea.calidad.immnosistemas17.userinterfaces.PaginaEntregaUI;
import net.serenitybdd.screenplay.Question;

public class DocumentoVisible {
    public static Question<Boolean> enPantalla() {
        return actor -> PaginaEntregaUI.DOCUMENTO_SUBIDO.resolveFor(actor).isVisible();
    }
}