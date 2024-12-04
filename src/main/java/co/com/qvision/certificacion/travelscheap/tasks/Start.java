package co.com.qvision.certificacion.travelscheap.tasks;

import co.com.qvision.certificacion.travelscheap.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {

    private HomePage homePage;

    public static Start openTheWebsite(){
        return instrumented(Start.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(homePage));
    }
}
