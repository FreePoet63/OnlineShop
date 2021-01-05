import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface OnlainerPage extends WebPage {

    @FindBy("//span[contains(text(), '{{ text }}')]")
    AtlasWebElement setBook (@Param("text") String text);

    @FindBy("//a[contains(text(), '{{ text }}')]")
    AtlasWebElement Button (@Param("text") String text);

    @FindBy("//a[contains(@class, '{{ text }}')]")
    AtlasWebElement newButton (@Param("text") String text);

    @FindBy("//a[@class=\"button-style button-style_auxiliary button-style_small " +
            "cart-form__button cart-form__button_remove\"]")
    AtlasWebElement Delete();
}
