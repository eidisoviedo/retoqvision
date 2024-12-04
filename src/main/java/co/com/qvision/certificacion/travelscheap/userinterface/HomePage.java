package co.com.qvision.certificacion.travelscheap.userinterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#home")
public class HomePage extends PageObject {

    public static final Target LOCATION = Target.the("Location")
            .locatedBy("//input[contains(@id,'location')]");

    public static final Target CHECK_IN_DATE = Target.the("Check In")
            .locatedBy("//input[contains(@id,'checkIn')]");

    public static final Target CHECK_OUT_DATE = Target.the("Check Out")
            .locatedBy("//input[contains(@id,'checkOut')]");

    public static final Target NUMBER_OF_ROOMS = Target.the("Rooms")
            .locatedBy("//input[contains(@id,'rooms')]");

    public static final Target NUMBER_OF_ADULTS = Target.the("Adults")
            .locatedBy("//input[contains(@id,'adults')]");

    public static final Target NUMBER_OF_CHILDREN = Target.the("Children")
            .locatedBy("//input[contains(@id,'children')]");

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .locatedBy("//div[@class='search main-color white-text dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-text']//div[@class='dx-button-content']");

}
