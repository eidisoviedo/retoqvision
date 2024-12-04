package co.com.qvision.certificacion.travelscheap.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


import java.util.ArrayList;
import java.util.List;

import static co.com.qvision.certificacion.travelscheap.userinterface.SearchPage.COUNT_OF_HOTELS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectMostCheapestHotel implements Interaction {

    private String numberofhotels;
    private String price;
    private String locationprice;
    public static String PRICE_PER_NIGHT="pricepernight";

    List<Integer> prices = new ArrayList<Integer>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        int i;
        int j=0;
        int minor;
        int major;
        int positionMinor=0;
        String positionbookit ="";
        numberofhotels = COUNT_OF_HOTELS.resolveFor(actor).getText();
        numberofhotels = numberofhotels.charAt(0) +"";
        if (Integer.parseInt(numberofhotels)>=3){
            i=3;
        } else {
            i=Integer.parseInt(numberofhotels);
        }
        while (j<=i){
            j++;
            locationprice = Integer.toString(j);
            Target PRICE = Target.the("Precio hotel")
                    .locatedBy("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div["+locationprice+"]/div[1]/div[2]/div[1]");
            price = PRICE.resolveFor(actor).getText();
            price = price.replace("$","");
            prices.add(Integer.parseInt(price));

            if (j==i){break;}
        }

        minor = major = prices.get(0);
        for(int x=0; x<prices.size(); x++){
            if(prices.get(x)>major){
                major=prices.get(x);
            } else if (prices.get(x)<minor){
                minor=prices.get(x);
                positionMinor = x;
            }
        }
        actor.remember(PRICE_PER_NIGHT, minor);
        positionbookit = Integer.toString(positionMinor+1);
        Target BOOK_IT = Target.the("Book it button")
                .locatedBy("//body/div[@class='dx-viewport dx-device-desktop dx-device-generic dx-theme-generic dx-theme-generic-typography dx-color-scheme-light']/div[@class='desktop-layout dx-layout']/div[@class='page']/div[@class='wrapper']/div[@class='content-wrapper']/div[@class='dx-content-placeholder dx-content-placeholder-content dx-transition-absolute dx-transition dx-transition-content dx-transition-none']/div[@class='dx-content dx-content-content dx-transition-inner-wrapper dx-active-view']/div[@class='search-info-hotels']/div[@class='hotels content']/div[@class='current-hotels']/div["+positionbookit+"]/div[1]/div[2]/div[3]/div[1]");

        actor.attemptsTo(
                Click.on(BOOK_IT)
        );
    }

    public static SelectMostCheapestHotel selectMostCheapestHotel (){
        return instrumented(SelectMostCheapestHotel.class);
    }

}
