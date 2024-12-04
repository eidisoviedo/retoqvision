package co.com.qvision.certificacion.travelscheap.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFromDropDown implements Interaction {

    public final String option;
    public final String position;

    public SelectFromDropDown(String option, String position) {
        this.option = option;
        this.position = position;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target DROPDOWN_LIST = Target.the("Drop down options")
                .locatedBy("(//div[@class='dx-item-content dx-list-item-content'][contains(text(),'"+ option +"')])[{0}]");
        actor.attemptsTo(Click.on(DROPDOWN_LIST.of(position)));
    }

    public static SelectFromDropDown theDropDownOptions(String option, String position){
        return instrumented(SelectFromDropDown.class, option, position);
    }
}
