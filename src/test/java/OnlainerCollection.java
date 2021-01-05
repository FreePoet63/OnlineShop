import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface OnlainerCollection extends WebPage {

    @FindBy("//div[contains(@class, \"schema-filter-control\")]")
    ElementsCollection<WebElement> itemsCollection();

    @FindBy("//div[@class=\"schema-filter-popover schema-filter-popover_visible\"]//label")
    ElementsCollection<WebElement> collectionLabel();

    @FindBy("//div[contains(@class, \"schema-filter-control\")]//input")
    ElementsCollection<WebElement> priceCollection();

    @FindBy("//div[@class=\"schema-product__part schema-product__part_2\"]")
    ElementsCollection<WebElement> resultBook();

    @FindBy("//div[@class=\"cart-form__offers-unit cart-form__offers-unit_primary\"]")
    ElementsCollection<WebElement> newProd();
}
