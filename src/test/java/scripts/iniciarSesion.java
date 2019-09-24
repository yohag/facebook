package scripts;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import Tools.tools;
import Tools.tools2;  //primera línea
import pageFactory.pageIndex;

public class iniciarSesion {
	
	private static tools tools2;  //se inicializa 
	private static WebDriver driver;
	private static ScreenRecorder screenRecorder; //línea

    tools tools;
    pageIndex objIndex;

    List<String> errores = new ArrayList<>();
    String _directory = "scripts";
    String _class = "iniciarSesion";
    String _method = "";

    String Caso = "iniciarSesion";

    boolean continuar = true;

    @BeforeTest
    public void ejecutarBrowser() {
        tools = new tools();
        try {
            System.out.println("Se ejecuta chromedriver");
            Thread.sleep(100);
            tools.setUrl("https://www.facebook.com");
            tools.init();
            Thread.sleep(300);
//            tools2.iniciarGrabacion; //línea..
            tools2.screenshot("scripts", Caso , "Cargar URL");
            System.out.println("Se inicia el paso 1");
            Thread.sleep(100);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            tools.stop();
        }

    }

    @Test (priority = 1)
    public void ingresarCorreo() {
        objIndex = new pageIndex(tools.getDriver());
        try {
            System.out.println("Se Ingresa un Correo valido");
            Thread.sleep(300);
            objIndex.textCorreo.click();
            Thread.sleep(300);
            objIndex.textCorreo.sendKeys("yohag07@gmail.com");
            tools2.screenshot("scripts", Caso , "Ingreso de Correo Válido");
            Thread.sleep(300);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools2.stop();
        }

    }

    @Test (priority = 2)
    public void ingresarPassword() {
        objIndex = new pageIndex(tools.getDriver());
        try {
            System.out.println("Se Ingresa una contraseña valida");
            Thread.sleep(300);
            objIndex.textPass.click();
            Thread.sleep(300);
            objIndex.textPass.sendKeys("123456");
            tools.screenshot("scripts", Caso , "Ingreso de Contraseña Válida");
            Thread.sleep(300);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools.stop();
        }

    }

    @Test (priority = 3)
    public void presionarBotonIngresar() {
        objIndex = new pageIndex(tools.getDriver());
        try {
            System.out.println("Se presionará botón Ingresar");
            Thread.sleep(1000);
            objIndex.btnIngresar.click();
            tools.screenshot("scripts", Caso , "Ingresando a Facebook");
            Thread.sleep(300);
            objIndex.bodyFacebook.click();
            Thread.sleep(3000);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools2.stop();
        }

    }

    @Test (priority = 4)
    public void abrirMenuPerfil() {
        objIndex = new pageIndex(tools.getDriver());
        try {
            System.out.println("Se presionará selección de Menú");
            Thread.sleep(1000);
            objIndex.btnMenuPerfil.click();
            tools2.screenshot("scripts", Caso , "Ingresando a Menú");
            Thread.sleep(3000);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools2.stop();
        }

    }

    @Test (priority = 5)
    public void cerrarSesion() {
        objIndex = new pageIndex(tools.getDriver());
        try {
            System.out.println("Se presionará cerrar sesión");
            Thread.sleep(1000);
            objIndex.btnCerrarSesion.click();
            tools2.screenshot("scripts", Caso , "Se cierra sesión con éxito");
            Thread.sleep(5000);

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools2.stop();
        }

    }
    
    @AfterTest
    public void cerrarBrowser() {
        try {

            System.out.println("Cerrando Caso");
            tools2.screenshot("scripts", Caso , "Prueba Finalizada");
            Thread.sleep(2000);
            tools2.finalizarGrabacion();    //línea ...
            Thread.sleep(2000);
            tools2.stop();

        } catch (Exception e) {
            continuar = false;
            tools.skipScript(e);
            System.out.println("El paso " + _method + "no ha podido ser ejecutado satisfactoriamente, se detiene el script");
            tools2.stop();
        }

    }
}
