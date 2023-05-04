package estructuraCristian;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import flujos.*;
import funciones.funcionesPrincipales;


public class principal extends funcionesPrincipales{


private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
				
	}

	
	@Test(priority=1)
	public void testFormularioNombreyCorreo()  throws InterruptedException, AWTException
	{
	
		registroUsuario.llenarNombreyApellido(driver, "firstName", "test4", "lastName", "test2");
		registroUsuario.correoElectronico(driver,"userEmail" ,"cristian4@gmail.com");
		screenshot(driver, "llenarNombre");
	
	}
	
	@Test(priority=2)
	public void testFormularioSexoyNumero()  throws InterruptedException
	{
		sexoUsuario.sexoUsuario(driver, "//div[@id='genterWrapper']/div[2]/div[");
		sexoUsuario.numeroUsuario(driver, "userNumber", "10101010");
		screenshot(driver, "sexoynumero");
	}
	
	
	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
}
