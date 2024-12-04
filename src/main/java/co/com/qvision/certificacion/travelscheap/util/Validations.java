package co.com.qvision.certificacion.travelscheap.util;

import java.util.Date;

public class Validations {

    private Validations() {
    }

    public static boolean isEmptyOrNull(String value){
        return value == null || value.isEmpty();
    }

    public static int numberOfDaysBetweenDates (Date datecheckin, Date datecheckout){
        long startTime = datecheckin.getTime();
        long endTime = datecheckout.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime/(1000*60*60*23);
        return (int)diffDays;
    }

}
