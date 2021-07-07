package Drivers;

public class FireFoxFactory {

    public void testeBrowserFireFox() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
    }
}
