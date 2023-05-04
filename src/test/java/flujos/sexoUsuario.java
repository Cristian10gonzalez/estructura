package flujos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sexoUsuario {

	
	
	public static void sexoUsuario(WebDriver driver, String xpath) {
	int n = (int) (Math.random() * (4 - 1)) + 1;
    WebElement radio_btn = driver.findElement(By.xpath(xpath+ n +"]/label"));
    radio_btn.click();
	}

	public static void numeroUsuario(WebDriver driver, String idTelefono, String telefono)
	{
    WebElement user_number = driver.findElement(By.id(idTelefono));
    user_number.click();
    user_number.sendKeys(telefono);
	}
}
