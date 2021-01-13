import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import io.qameta.allure.*;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class Onliner21vekTest {

    FirefoxDriver driver;
    Atlas atlas;
    Shadow shadow = null;

    @Before
    public void startFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        atlas = new Atlas(new WebDriverConfiguration(driver));
        shadow = new Shadow(driver);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @Description("Search for a laptop using sorting and filters and add an item to the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Testing Onliner shop")
    public void searchBook() throws InterruptedException {
        onPage(OnlainerPage.class).open("https://www.onliner.by/");
        onPage(OnlainerPage.class).setBook("Ноутбуки").click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)", "");
        onPage(OnlainerCollection.class).itemsCollection().get(3).click();
        onPage(OnlainerCollection.class).collectionLabel().get(0).click();
        onPage(OnlainerCollection.class).collectionLabel().get(15).click();
        onPage(OnlainerCollection.class).priceCollection().get(0).sendKeys("1000");
        onPage(OnlainerCollection.class).priceCollection().get(1).sendKeys("2000");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 400)", "");
        onPage(OnlainerCollection.class).itemsCollection().get(7).click();
        onPage(OnlainerCollection.class).collectionLabel().get(0).click();
        onPage(OnlainerCollection.class).collectionLabel().get(2).click();
        onPage(OnlainerCollection.class).priceCollection().get(2).sendKeys("2019");
        onPage(OnlainerCollection.class).priceCollection().get(3).sendKeys("2020");
        JavascriptExecutor jsxj = (JavascriptExecutor) driver;
        jsxj.executeScript("window.scrollBy(0, 400)", "");
        onPage(OnlainerCollection.class).itemsCollection().get(10).click();
        onPage(OnlainerCollection.class).collectionLabel().get(0).click();
        onPage(OnlainerCollection.class).collectionLabel().get(2).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0, 1000)", "");
        onPage(OnlainerCollection.class).itemsCollection().get(18).click();
        onPage(OnlainerCollection.class).collectionLabel().get(1).click();
        onPage(OnlainerCollection.class).collectionLabel().get(7).click();
        JavascriptExecutor jsxc = (JavascriptExecutor) driver;
        jsxc.executeScript("window.scrollBy(0, 800)", "");
        onPage(OnlainerCollection.class).itemsCollection().get(26).click();
        onPage(OnlainerCollection.class).collectionLabel().get(0).click();
        onPage(OnlainerCollection.class).collectionLabel().get(2).click();
        onPage(OnlainerCollection.class).collectionLabel().get(3).click();
        Thread.sleep(5000);
        List<WebElement> resultsItems = onPage(OnlainerCollection.class).resultBook();
        System.out.println(resultsItems.size());
        ArrayList<String> resultsItemsText = new ArrayList<String>();
        for (WebElement elementResult : resultsItems)
            resultsItemsText.add(elementResult.getText());
        assertThat(resultsItemsText, hasItems(containsString("Ноутбук Acer Aspire 5"),
                containsString("Ноутбук Acer Aspire 3")));
        onPage(OnlainerPage.class).setBook("Ноутбук Acer Aspire 5").click();
        onPage(OnlainerPage.class).newButton("button_big offers-description__button").click();
        onPage(OnlainerPage.class).Button("Купить").click();
        Thread.sleep(5000);
        onPage(OnlainerPage.class).newButton("item--cart").click();
        List<WebElement> prod = onPage(OnlainerCollection.class).newProd();
        prod.size();
        ArrayList<String> prodText = new ArrayList<String>();
        for (WebElement ely : prod)
            prodText.add(ely.getText());
        assertThat(prodText, hasItem(containsString("Acer Aspire 5")));
        screenshotPNG();
        Actions act = new Actions(driver);
        WebElement elu = onPage(OnlainerPage.class).Delete();
        act.moveToElement(elu).click().build().perform();

    }

    @Test
    @Description("TV selection using the filters, the product in the basket")
    @Severity(SeverityLevel.BLOCKER)
    @Story("The purchase of the goods")
    public void SearchPhone() throws InterruptedException {
        onPage(VekPage.class).open("https://www.21vek.by/");
        onPage(VekPage.class).itemName("Электроника").click();
        onPage(VekPage.class).nameProduct("Телевизоры").click();
        Actions actional = new Actions(driver);
        WebElement ele = onPage(VekPage.class).slider1();
        WebElement elle = onPage(VekPage.class).slider2();
        actional.dragAndDropBy(ele,10,0).perform();
        actional.dragAndDropBy(elle,-330,0).perform();
        Thread.sleep(5000);
        JavascriptExecutor jsi = (JavascriptExecutor) driver;
        jsi.executeScript("window.scrollBy(0, 500)", "");
        onPage(VekCollection.class).itemEnam().get(0).click();
        onPage(VekPage.class).elementDia("LG").click();
        onPage(VekPage.class).elementDia("Samsung").click();
        JavascriptExecutor jsix = (JavascriptExecutor) driver;
        jsix.executeScript("window.scrollBy(0, 300)", "");
        onPage(VekPage.class).itemName("Диагональ").click();
        onPage(VekCollection.class).itemEnam().get(1).click();
        onPage(VekCollection.class).itemDia().get(4).click();
        List<WebElement> elium = onPage(VekCollection.class).itemDia();
        WebElement elaium = elium.get(22);
        JavascriptExecutor jsixy = (JavascriptExecutor) driver;
        WebElement element = onPage(VekPage.class).elementDia("85");
        WebElement elementos = onPage(VekPage.class).elementDia("75");
        jsixy.executeScript("arguments[0].click();", element);
        jsixy.executeScript("arguments[0].click();", elementos);
        JavascriptExecutor jsy = (JavascriptExecutor) driver;
        jsy.executeScript("window.scrollBy(0, 300)", "");
        onPage(VekPage.class).itemName("Smart TV").click();
        onPage(VekCollection.class).itemParam().get(0).click();
        onPage(VekPage.class).itemName("Показать товары").click();
        List<WebElement> result = onPage(VekCollection.class).resultItems();
        result.size();
        ArrayList<String> textResult = new ArrayList<String>();
        for (WebElement e : result)
            textResult.add(e.getText());
        assertThat(textResult, hasItems(containsString("Телевизор Samsung"),containsString(
                "Телевизор LG")));
        onPage(VekPage.class).itemName("Телевизор LG").click();
        onPage(VekCollection.class).button().get(0).click();
        onPage(VekPage.class).itemName("Корзина").click();
        List<WebElement> product = onPage(VekCollection.class).basketProd();
        product.size();
        ArrayList<String> productText = new ArrayList<String>();
        for (WebElement el : product)
            productText.add(el.getText());
        assertThat(productText, hasItem(containsString("Телевизор LG")));
        screenshotPNG();
        onPage(VekPage.class).nameProduct("удалить").click();
    }

    @After
    public void closeOnliner() {
        driver.quit();
    }
}






