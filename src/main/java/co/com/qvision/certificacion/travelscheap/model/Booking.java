package co.com.qvision.certificacion.travelscheap.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking  {

    private final String location;
    private final Date datecheckin;
    private final String numberofrooms;
    private final String adultsnumber;
    private final String childsnumber;

    public Booking(String location, String datecheckin, String numberofrooms, String adultsnumber, String childsnumber) {
        this.location = location;
        try {
            this.datecheckin = date(datecheckin);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.numberofrooms = numberofrooms;
        this.adultsnumber = adultsnumber;
        this.childsnumber = childsnumber;
    }

    private Date date(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(date);
    }

    public Date getDatecheckin() {
        return datecheckin;
    }

    public String getLocation() {
        return location;
    }

    public String getNumberofrooms() {
        return numberofrooms;
    }

    public String getAdultsnumber() {
        return adultsnumber;
    }

    public String getChildsnumber() {
        return childsnumber;
    }
}
