package co.com.qvision.certificacion.travelscheap.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.qvision.certificacion.travelscheap.interactions.CalculatePrice.CAP_TOTAL_PRICE;

public class ThePriceOfBooking implements Question<String> {

    public ThePriceOfBooking() {

    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall(CAP_TOTAL_PRICE).toString();
    }

    public static ThePriceOfBooking showOnScreen(){
        return new ThePriceOfBooking();
    }
}
