package co.com.qvision.certificacion.travelscheap.tasks;

import co.com.qvision.certificacion.travelscheap.interactions.SelectFromDropDown;
import co.com.qvision.certificacion.travelscheap.model.Booking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.joda.time.DateTime;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

import static co.com.qvision.certificacion.travelscheap.userinterface.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class BookingAHotel implements Task {

    private final Booking booking;
    public static String DATE_CHECK_IN = "checkin";
    public static String DATE_CHECK_OUT = "checkout";

    public BookingAHotel(Booking booking) {
        this.booking = booking;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String dateCheckint = plusDate(booking.getDatecheckin(), 2, "dd/MM/yyyy");
        String datecheckout = plusDate(booking.getDatecheckin(), 9, "MM/dd/yyyy");

        actor.attemptsTo(
                Click.on(NUMBER_OF_ROOMS),
                SelectFromDropDown.theDropDownOptions(booking.getNumberofrooms(), "1"),
                Click.on(NUMBER_OF_ADULTS),
                SelectFromDropDown.theDropDownOptions(booking.getAdultsnumber(), "2"),
                Click.on(NUMBER_OF_CHILDREN),
                SelectFromDropDown.theDropDownOptions(booking.getChildsnumber(), "3"),
                Click.on(LOCATION),
                SelectFromDropDown.theDropDownOptions(booking.getLocation(), "1"),
                Enter.theValue(dateCheckint).into(CHECK_IN_DATE).thenHit(Keys.TAB),
                Enter.theValue(datecheckout).into(CHECK_OUT_DATE).thenHit(Keys.TAB),
                Click.on(SEARCH_BUTTON)
        );
        actor.remember(DATE_CHECK_IN, dateCheckint);
        actor.remember(DATE_CHECK_OUT, datecheckout);

    }


    public static BookingAHotel withTheFollowingData(Booking booking) {
        return instrumented(BookingAHotel.class, booking);
    }


    private static String plusDate(Date date, int plusNumber, String simpleFormat) {
        SimpleDateFormat format = new SimpleDateFormat(simpleFormat);
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlusOne = dtOrg.plusDays(plusNumber);
        return format.format(dtPlusOne.toDate());
    }
}
