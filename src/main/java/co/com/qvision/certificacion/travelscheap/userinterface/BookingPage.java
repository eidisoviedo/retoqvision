package co.com.qvision.certificacion.travelscheap.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class BookingPage{

    private BookingPage(){}

    public static final Target TOTAL_PRICE = Target.the("Total price")
            .locatedBy("//h4[@class='total-price']");

}
