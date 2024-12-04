package co.com.qvision.certificacion.travelscheap.interactions;

import co.com.qvision.certificacion.travelscheap.util.Validations;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static co.com.qvision.certificacion.travelscheap.interactions.SelectMostCheapestHotel.PRICE_PER_NIGHT;
import static co.com.qvision.certificacion.travelscheap.tasks.BookingAHotel.DATE_CHECK_IN;
import static co.com.qvision.certificacion.travelscheap.tasks.BookingAHotel.DATE_CHECK_OUT;
import static co.com.qvision.certificacion.travelscheap.userinterface.BookingPage.TOTAL_PRICE;

public class CalculatePrice implements Interaction {
    private int numberofdays;
    private String totalprice;
    private int totalpricefinal;
    private int pricepernight;
    public static String CAP_TOTAL_PRICE="captotalprice";
    public static String CALC_PRICE = "calctotalprice";

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            String checkin = actor.recall(DATE_CHECK_IN).toString();
            String checkout = actor.recall(DATE_CHECK_OUT).toString();
            Date datecheckout = new SimpleDateFormat("MM/dd/yyyy").parse(checkout);
            Date datecheckin = new SimpleDateFormat("MM/dd/yyyy").parse(checkin);
            numberofdays = Validations.numberOfDaysBetweenDates(datecheckin,datecheckout)+1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        totalprice = TOTAL_PRICE.resolveFor(actor).getText();
        totalprice = totalprice.replace("$","");
        totalprice = totalprice.replace(".00","");
        totalpricefinal = Integer.parseInt(totalprice);
        actor.remember(CAP_TOTAL_PRICE,totalpricefinal);
        pricepernight = actor.recall(PRICE_PER_NIGHT);
        pricepernight = pricepernight*numberofdays;
        actor.remember(CALC_PRICE,pricepernight);
    }

    public static CalculatePrice calculateCorrectPrice (){
        return new CalculatePrice();
    }
}
