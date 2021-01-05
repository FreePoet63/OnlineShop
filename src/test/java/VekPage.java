import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface VekPage extends WebPage {

    @FindBy("//a[contains(text(), '{{ text }}')]")
    AtlasWebElement nameProduct (@Param("text") String text);

    @FindBy("//span[contains(text(), '{{ text }}')]")
    AtlasWebElement itemName (@Param("text") String text);

    @FindBy("//div[starts-with(@class, \"ui-slider\")]/a[1]")
    AtlasWebElement slider1();

    @FindBy("//div[starts-with(@class, \"ui-slider\")]/a[2]")
    AtlasWebElement slider2();

    @FindBy("//label[contains(@title,'{{ text }}')]")
    AtlasWebElement elementDia (@Param("text") String text);
}
