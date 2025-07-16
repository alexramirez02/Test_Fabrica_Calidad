package co.edu.udea.calidad.immnosistemas17.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaEntregaUI {

    public static final Target SELEC_TIPO_DOCUMENTO = Target.the("Botón para abrir selector de tipo de documento")
            .located(By.xpath("/html/body/main/div/div[1]/button"));

    public static final Target OPTCON_DOCUMENTO = Target.the("Opción Inteligencia Artificial")
            .located(By.xpath("//button[normalize-space()='Inteligencia Artificial']"));

    public static final Target RENGLON_NOMBRE_ARCHIVO = Target.the("Campo nombre del documento")
            .located(By.xpath("/html/body/main/div/div[2]/div/input[1]"));

    public static final Target SUBIR_DOCUMENTO = Target.the("Input para subir archivo")
            .located(By.cssSelector("input[type='file'][data-slot='input']"));


    public static final Target BOTON_ENVIAR = Target.the("Botón subir documento")
            .located(By.xpath("//button[contains(text(),'Subir documento')]"));
    // Este ya no se recomienda usar directamente si su ID cambia dinámicamente
    public static final Target DOCUMENTO_SUBIDO = Target.the("Texto del documento subido")
            .located(By.xpath("//div[contains(text(), 'archivo exitoso')]"));

    // Target dinámico para verificar cualquier texto esperado en pantalla
    public static Target textoDocumentoSubido(String textoEsperado) {
        return Target.the("Texto del documento subido: " + textoEsperado)
                .located(By.xpath("//*[contains(text(),'" + textoEsperado + "')]"));
    }
}
