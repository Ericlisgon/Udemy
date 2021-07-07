import Drivers.ChromeFactory;
import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class TesteFactory {

    @Test
    public void testBrowserFireFox() {
        FireFoxFactory baseFireFox = new FireFoxFactory();
        baseFireFox.testeBrowserFireFox();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Youtube");

        driver.quit();
    }

    @Test
    public void testYoutube(){
        ChromeFactory baseChrome = new ChromeFactory();
        baseChrome.testeBrowserChrome();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Youtube");
        driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
        driver.findElement(By.xpath("(//h3[contains(@class,'LC20lb DKV0Md')])[1]")).click();
        String nomeDoVideo = "Bring Me The Horizon - Can You Feel My Heart";
        driver.findElement(By.id("search")).sendKeys(nomeDoVideo);
        driver.findElement(By.id("search-icon-legacy")).click();
        //Para aguardar a pagina carregar (tem jeito melhor mas ja viu n quero aguardar
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isFound = false;
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='title-wrapper']"));
        for (WebElement searchResult: searchResults) {
            if(searchResult.getText().contains(nomeDoVideo)){
                searchResult.click();
                isFound = true;
                break;
            }
        }
        if(!isFound){
            throw new NotFoundException("Não foi encontrado o video com o seguinte titulo" + nomeDoVideo);
        }



//        driver.quit();
    }

}
