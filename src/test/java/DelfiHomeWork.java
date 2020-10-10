import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiHomeWork {

    private final By ARTICLE = By.xpath(".//article[contains(@class, 'headline')]");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_PAGE_COMMENT = By.xpath(".//a[contains(@class,'d-print-none')]");

    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By COMMENT_PAGE_COMMENT_COUNT_ANON = By.xpath(".//span[@class = 'type-cnt']");
    private final By COMMENT_PAGE_COMMENT_COUNT_REG = By.xpath(".//li[contains(@class, 'show-reg')]");
    private final By CLOSE_POPUP = By.id("adf-close-button");

    private WebDriver driver;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @BeforeEach
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test
    public void firstArticleCheck() {
        LOGGER.info("This test is to check First article name and comment count");
        final String TITLE_TO_FIND = "За сутки выявлено 89 новых случаев Covid-19";

        List<WebElement> texts = driver.findElements(ARTICLE);
        WebElement article = texts.get(0);
        String homePageTitle = article.findElement(TITLE).getText();

        int homePageCommentCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()){
            homePageCommentCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        System.out.println(homePageTitle + " " + homePageCommentCount);

        Assertions.assertTrue(homePageTitle.contains(TITLE_TO_FIND), "Wrong Title");


    }
       @Test
       public void thirdArticleCheck(){
        LOGGER.info("This test is to check 3rd article title and comment count within homepage, article pace and " +
                "comment page");


        LOGGER.info("Receive the title and comment count from 3rd article");
        List<WebElement> articles = driver.findElements(ARTICLE);
        WebElement article = articles.get(2);
        String homePageArticle = article.findElement(TITLE).getText();

        int homePageCommentCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()){
            homePageCommentCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        LOGGER.info("Open 3rd article");
        article.findElement(TITLE).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        LOGGER.info("Get comment count");
        int articlePageComment;
           articlePageComment = parseCommentCount(driver.findElement(ARTICLE_PAGE_COMMENT).getText());



           LOGGER.info("Compare article title and comments count between homepage and article page");
        Assertions.assertTrue(homePageArticle.startsWith(articlePageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentCount, articlePageComment, "Comment count wrong");


       }
     private int parseCommentCount(String textToParse){
            textToParse = textToParse.substring(1, textToParse.length()-1);
            return Integer.parseInt(textToParse);
        }

        @AfterEach
        private void closeBrowser(){driver.close();}
}
