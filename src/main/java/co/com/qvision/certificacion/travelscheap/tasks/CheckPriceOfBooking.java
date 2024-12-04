package co.com.qvision.certificacion.travelscheap.tasks;

import co.com.qvision.certificacion.travelscheap.interactions.SelectMostCheapestHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.qvision.certificacion.travelscheap.userinterface.SearchPage.COUNT_OF_HOTELS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckPriceOfBooking implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(COUNT_OF_HOTELS),
                SelectMostCheapestHotel.selectMostCheapestHotel()
        );
    }

    public static CheckPriceOfBooking theCheckOfPrice (){
        return instrumented(CheckPriceOfBooking.class);
    }

}
