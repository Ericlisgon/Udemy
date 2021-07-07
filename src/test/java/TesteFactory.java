import Drivers.ChromeFactory;
import Drivers.FireFoxFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.findElement(By.id("search")).sendKeys("Kaleo - I Can't Go on Without You (live on 89.3 The Current)");
        driver.findElement(By.id("search-icon-legacy")).click();
        

        driver.quit();
    }


}
