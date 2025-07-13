package co.edu.udea.calidad.immnosistemas17.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;

public class PaginaEntregaUI {
    public static final Target SELECT_TIPO_DOCUMENTO = Target.the("Selector de tipo de documento").locatedBy("select[name='tipoDocumento']");
    public static final Target OPTION_DOCUMENTO = Target.the("Opción Documento").locatedBy("option[value='documento']");
    public static final Target INPUT_DOCUMENTO = Target.the("Campo para subir documento").locatedBy("input[type='file']");
    public static final Target BOTON_ENVIAR = Target.the("Botón enviar").locatedBy("button#btnEnviar");
    public static final Target BOTON_ELIMINAR = Target.the("Botón eliminar").locatedBy("button#btnEliminar");
    public static final Target DOCUMENTO_SUBIDO = Target.the("Documento subido").locatedBy("div.documento-visible");
}
