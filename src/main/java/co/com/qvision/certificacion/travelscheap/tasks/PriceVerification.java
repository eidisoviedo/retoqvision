package co.com.qvision.certificacion.travelscheap.tasks;

import co.com.qvision.certificacion.travelscheap.interactions.CalculatePrice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class PriceVerification implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CalculatePrice.calculateCorrectPrice()
        );
    }
    public static PriceVerification isCorrectPrice(){
        return new PriceVerification();
    }
}
