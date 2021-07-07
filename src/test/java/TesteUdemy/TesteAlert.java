package TesteUdemy;

import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {

    @Test
    public void deveInteragirComAlertSimples(){
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///"+System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos a partir do campo abaixo!

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos a partir do campo abaixo!

        // Clicando no botão confirm e confirmando hehe.
        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertEquals("Confirmado", alerta.getText());
        alerta.accept();

        // Clicando no confirm, e na hora de confirmar irá apertar no cancelar.
        driver.findElement(By.id("confirm")).click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.dismiss();

        driver.quit();
    }

    @Test
    public void deveInteragirComAlertPrompt(){
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(900, 765));
        driver.get("file:///"+System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos a partir do campo abaixo!

        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("123456789");
        alerta.accept();
        Assert.assertEquals("Era 123456789?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();

        driver.quit();
    }

    @Test
    public void escrevaAi(){
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos a partir do campo abaixo!


        driver.quit();
    }
}
