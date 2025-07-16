package co.edu.udea.calidad.immnosistemas17.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class DocumentoVisible {
    public static Question<Boolean> enPantalla(String textoEsperado) {
        return actor -> {
            return net.serenitybdd.screenplay.targets.Target
                    .the("Texto del documento subido")
                    .located(By.xpath("//*[contains(text(),'" + textoEsperado + "')]"))
                    .resolveFor(actor)
                    .isVisible();
        };
    }
}
