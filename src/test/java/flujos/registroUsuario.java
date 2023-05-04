package flujos;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import funciones.*;
public class registroUsuario  {
	
	public static void llenarNombreyApellido(WebDriver driver, String idNombre, String nombre, String idApellido,
			String apellido) throws AWTException, InterruptedException {
		// NOMBRE
		WebElement first_name = driver.findElement(By.id(idNombre));
		first_name.click();
		first_name.sendKeys(nombre);
		
		funcionesPrincipales.scrollRaton();
		Thread.sleep(1000);
		
		funcionesPrincipales.scrollRaton();
		// APELLIDO
		WebElement last_name = driver.findElement(By.id(idApellido));
		last_name.click();
		last_name.sendKeys(apellido);
		
		
	}

	
	public static void correoElectronico(WebDriver driver, String idCorreo, String correo) {
		WebElement user_name = driver.findElement(By.id(idCorreo));
		user_name.click();
		user_name.sendKeys(correo);
	}
}
