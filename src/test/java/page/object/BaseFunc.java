package page.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunc {
    private WebDriver driver;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url){
        LOGGER.info("Try to open website: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://" + url;
        }
        driver.get(url);
    }
    public void closeBrowser(){
        driver.close();}


}
