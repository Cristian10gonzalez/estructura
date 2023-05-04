package funciones;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class funcionesPrincipales {
	
	public static void recorrerSelect(WebDriver driver, String id, String seleccion)
	{
		//Select - Recorrido 
    	WebElement selectElement = driver.findElement(By.id(id));
    	Select select = new Select(selectElement);
    	List<WebElement> opciones = select.getOptions();
    	for (WebElement opcion : opciones) {
    	    String lista = opcion.getText();
    	    if(lista.equals(seleccion))
    	    {
    	    opcion.click();	    	    
    	    }  
    	}
	}
	
	
	public static void scroll(WebDriver driver, String x, String y)
	{
		// Crear un objeto JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Hacer scroll hacia abajo
		js.executeScript("window.scrollBy("+x, y+");");
	}

	
	public static void scrollRaton() throws AWTException
	{
		Robot robot = new Robot();
		// Hacer scroll hacia abajo
		robot.mouseWheel(1); // Desplaza una unidad hacia abajo
	}
	
	
	public static String fechaCaptura()
	{
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");
		Date fecha = new Date();
		return formatoFecha.format(fecha); 
	}
	
	
	
	public static void screenshot(WebDriver driver, String nombre)
	{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			
		File screenshotRepetido = new File(nombre+" "+fechaCaptura()+".png");
		try {
			
			if(screenshotRepetido.exists())
			{
				System.out.println("La caputra ya existe");
				
			}
			else
			{
			FileUtils.copyFile(screenshot, new File(nombre+" "+fechaCaptura()+".png"));//archvio fuente que lo copia aun archivo destino
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void before(WebDriver driver, String ruta)
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ruta);
	}
	
	
	
	
	
}
