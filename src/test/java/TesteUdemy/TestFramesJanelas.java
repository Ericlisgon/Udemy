package TesteUdemy;

import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFramesJanelas {


    @Test
    public void deveInteragirComFrame() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva o código a partir da próxima linha!

        driver.switchTo().frame("frame1"); // Leva o foco para o frame
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!" , msg);
        alert.accept();

        driver.switchTo().defaultContent(); // Traz o foco de volta para a página completa
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
//        driver.quit();
    }

    @Test
    public void deveInteragirComJanelas() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva o código a partir da próxima linha!

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("E agora que deu tudo certo!!! \n\t\t\t\t\tAté a Próxima :D");
        driver.quit();
    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva o código a partir da próxima linha!

        driver.findElement(By.id("buttonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.tagName("textarea")).sendKeys("Sim, deu certo!");

        driver.quit();
    }

    @Test
    public void deveValidarCampoNome() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva o código a partir da próxima linha!
        driver.findElement(By.id("elementosForm:nome")).sendKeys("");

    }

    @Test
    public void c() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva o código a partir da próxima linha!

    }

    }
