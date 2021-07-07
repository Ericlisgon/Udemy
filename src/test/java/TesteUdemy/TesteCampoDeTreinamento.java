package TesteUdemy;

import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
        Escopo dos elementos básicos do Selenium e Junit!

        Cada teste feito, tem seus nomes dedicados a cada teste básico facilitando o entender de cada teste.
        Boa sorte nos estudos Ericlis!
 */

public class TesteCampoDeTreinamento{

    @Test
    public void testeTextField(){
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///"+System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Olha ele ai");
        Assert.assertEquals("Olha ele ai", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        driver.quit();
    }

    @Test
    public void deveInteragirComTextArea() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
        Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        driver.quit();
    }


    @Test
    public void deveInteragirComRadioButton() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        driver.quit();
    }


    @Test
    public void deveInteragirComCheckBox() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!


    }

    @Test
    public void deveInteragirComCombo() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
//        combo.selectByIndex(2);
//        combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");

        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        driver.quit();
    }

    @Test
    public void deveVerificarValoresCombo() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);

        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8 , options.size());

        boolean encontrou = false;
        for (WebElement option: options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        System.out.println("Encontrou: "+encontrou);

        Assert.assertTrue(encontrou);
        driver.quit();
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        driver.quit();
    }

    @Test
    public void deveInteragirComBotoes() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        driver.quit();
    }


    @Test
    @Ignore
    public void deveInteragirComLinks() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!
        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());

        driver.quit();
    }

    @Test
    public void deveBuscarTextosNaPagina() {
        FireFoxFactory fireFoxFactory = new FireFoxFactory();
        fireFoxFactory.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        //Escreva os códigos na linha de baixo!

//        Assert.assertTrue(driver.findElement(By.tagName("body"))
//                .getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());

        driver.quit();
    }
}
