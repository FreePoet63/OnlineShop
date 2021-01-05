import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface VekCollection extends WebPage {

    @FindBy("//dl[@class=\"b-filter-attr j-producers cr-filter_viewadd\"]//label[starts-with(@class, \"g-form\")]")
    ElementsCollection<WebElement> itemTele();

    @FindBy("//dl[@class=\"b-filter-attr cr-filter__toggle cr-filter__unfold cr-filter_viewadd\"]//label")
    ElementsCollection<WebElement> itemDia();

    @FindBy("//dd[starts-with(@class, \"filter\")]//span[contains(text(), \"Показать всё\")]")
    ElementsCollection<WebElement> itemEnam();

    @FindBy("//dl[contains(@class, \"b-filter-attr cr-filter__toggle  cr-filter__small cr-filter__unfold\")]//label")
    ElementsCollection<WebElement> itemParam();

    @FindBy("//li[starts-with(@class, \"result__item\")]")
    ElementsCollection<WebElement> resultItems();

    @FindBy("//button[contains(text(), \"В корзину\")]")
    ElementsCollection<WebElement> button();

    @FindBy("//td[contains(@class, \"g-table-cell basket__item cr-basket__name\")]")
    ElementsCollection<WebElement> basketProd();
}
