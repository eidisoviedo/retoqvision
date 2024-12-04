package co.com.qvision.certificacion.travelscheap.userinterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#hotels")
public class SearchPage extends PageObject {

    public static final Target STAR = Target.the("Filter for star")
            .locatedBy("(//div[contains(@class,'dx-checkbox dx')])[{0}]");

    public static final Target COUNT_OF_HOTELS = Target.the("Count of hotels")
            .locatedBy("//p[@class='count']");

    public static final Target NEXT_PAGE_BTN = Target.the("Next page")
            .locatedBy("//div[@class='switch switch-right']");

    public static final Target PREV_PAGE_BTN = Target.the("Previous page")
            .locatedBy("//div[@class='switch switch-left']");

}
