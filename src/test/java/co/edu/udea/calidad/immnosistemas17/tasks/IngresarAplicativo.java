package co.edu.udea.calidad.immnosistemas17.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class IngresarAplicativo {
    public static Task enLaPagina() {
        return Task.where("El usuario ingresa al aplicativo",
                Open.url("https://innosistemas-feature-5.vercel.app/")

        );
    }
}