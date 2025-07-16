package co.edu.udea.calidad.immnosistemas17.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import co.edu.udea.calidad.immnosistemas17.tasks.EnviarFormularioEntrega;
import co.edu.udea.calidad.immnosistemas17.questions.DocumentoVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EntregaDocumentoStepDefinitions {

    private Actor actor = Actor.named("Usuario");
    private WebDriver driver;

    @Before
    public void configurar() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new"); // Headless moderno para Chrome 109+
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.err.println("Error al iniciar ChromeDriver: " + e.getMessage());
            throw e;
        }

        actor.can(BrowseTheWeb.with(driver));
        driver.get("https://innosistemas-feature-5.vercel.app/");
    }

    @Given("el usuario esta en la pagina de gestion de documentos")
    public void el_usuario_esta_en_la_pagina_de_gestion_de_documentos() {
        // Página ya cargada en @Before
    }

    @When("el usuario selecciona {string} y sube el documento {string} con el nombre {string}")
    public void el_usuario_selecciona_tipo_y_sube_el_documento_con_nombre(String tipo, String archivo, String nombre) {
        actor.attemptsTo(EnviarFormularioEntrega.conArchivoYNombre(archivo, nombre));
    }

    @Then("el documento {string} aparece en la lista")
    public void el_documento_aparece_en_la_lista(String textoEsperado) {
        actor.should(seeThat(DocumentoVisible.enPantalla(textoEsperado), is(true)));
    }
}
