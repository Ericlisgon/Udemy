package Exercicios;

import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Exercicio_cadastroCompleto {

    @Test
    public void inserindoValoresNoCadastro() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        // Inserindo caracteres no campo textFild = Nome e fazendo teste do mesmo
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ericlis");
        Assert.assertEquals("Ericlis",  driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        // Inserindo caracteres no campo textFild = Sobrenome e fazendo teste do mesmo
        driver.findElement(By.id("elementosForm:Sobrenome")).sendKeys("Gonçalves");
        Assert.assertEquals("Gonçalves",  driver.findElement(By.id("elementosForm:Sobrenome")).getAttribute("value"));

        // Inserindo valores no campo RadioButton e fazendo teste do mesmo
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        // Inserindo valores no campo CheckBox e fazendo teste do mesmo
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        // Inserindo valores no campo Combo e fazendo teste do mesmo
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

        // Inserindo valores no combo multiplo e fazendo teste do mesmo
        element = driver.findElement(By.id("elementosForm:esportes"));
        combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Corrida");
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        // Inserindo valores no textArea e fazendo teste do mesmo
        driver.findElement(By.id("elementosForm:sugestoes"))
                .sendKeys("Hoje você tem a oportunidade de construir o amanhã que você deseja.");
        Assert.assertEquals("Hoje você tem a oportunidade de construir o amanhã que você deseja."
                , driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        // Finalizando o cadastro!
        driver.findElement(By.id("elementosForm:cadastrar")).click();


        // Fazendo teste do cadastro
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Ericlis"));
        Assert.assertEquals( "Sobrenome: Gonçalves" , driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino" , driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza" , driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior" , driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao Futebol Corrida" , driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes: Hoje você tem a oportunidade de construir o amanhã que você deseja." , driver.findElement(By.id("descSugestoes")).getText());

        driver.quit();
    }

    @Test
    public void deveValidarNomeObrigatorio() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos na próxima linha!!


        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio" , alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos na próxima linha!!

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ericlis");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio" , alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos na próxima linha!!

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ericlis");
        driver.findElement(By.id("elementosForm:Sobrenome")).sendKeys("Ericlis");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio" , alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarComidaVegetariana() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos na próxima linha!!

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ericlis");
        driver.findElement(By.id("elementosForm:Sobrenome")).sendKeys("Gonçalves");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?" , alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        // Escreva os códigos na próxima linha!!

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ericlis");
        driver.findElement(By.id("elementosForm:Sobrenome")).sendKeys("Gonçalves");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?" , alert.getText());
        driver.quit();
    }


    }
