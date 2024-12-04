package co.com.qvision.certificacion.travelscheap.stepdefinitions;

import co.com.qvision.certificacion.travelscheap.exceptions.PriceCheckException;
import co.com.qvision.certificacion.travelscheap.model.Booking;
import co.com.qvision.certificacion.travelscheap.questions.ThePriceOfBooking;
import co.com.qvision.certificacion.travelscheap.tasks.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static co.com.qvision.certificacion.travelscheap.interactions.CalculatePrice.CALC_PRICE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class CreateBookingInAMostCheapestHotelStepDefinition {

    @DataTableType
    public Booking bookingData(Map<String, String> entry){
        return new Booking(
                entry.get("location"),
                entry.get("datecheckin"),
                entry.get("numberofrooms"),
                entry.get("adultsnumber"),
                entry.get("childsnumber")
        );
    }


    @Given("^I want to start in travel page$")
    public void iWantToStarInTravelPage () {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Eidys");
        theActorInTheSpotlight().wasAbleTo(Start.openTheWebsite());
    }

    @When("make a reservation at the cheapest {} star hotel with the details")
    public void youMadeABookingInTheCheapestHotelWithTheData (Integer star, Booking bookingData ) {
        theActorInTheSpotlight().attemptsTo(
                BookingAHotel.withTheFollowingData(bookingData),
                Filter.forStar(String.valueOf(star)),
                CheckPriceOfBooking.theCheckOfPrice(),
                PriceVerification.isCorrectPrice()
        );
    }

    @Then("^I should see the price most cheapest and the booking price is correctly for number of days$")
    public void iShouldSeeThePriceMostCheapestAndTheBookingPriceIsCorrectlyForNumberOfDays () {
        theActorInTheSpotlight().should(
                seeThat(ThePriceOfBooking.showOnScreen(), is(theActorInTheSpotlight().recall(CALC_PRICE).toString())).orComplainWith(PriceCheckException.class)
        );
    }
}
