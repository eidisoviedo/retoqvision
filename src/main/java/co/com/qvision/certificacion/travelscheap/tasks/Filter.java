package co.com.qvision.certificacion.travelscheap.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.qvision.certificacion.travelscheap.userinterface.SearchPage.STAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Filter implements Task {

    private final String star;

    public Filter(String star) {
        this.star = star;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(STAR.of(star))
        );
    }


    public static Filter forStar(String star) {
        return instrumented(Filter.class, star);
    }
}
