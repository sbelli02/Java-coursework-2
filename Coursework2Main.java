import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * "Driver class" to exercise some of the functionalities provided by the
 * Booking hierarchy.
 *
 * @author Sandro Bellini
 */
public class Coursework2Main {

    /* Some helper methods to generate test objects */

    /**
     * @return a date sufficiently far in the future (seen from 2018/9) 
     */
    public static Date mkFutureDate() {
        Calendar cal = new GregorianCalendar(2020, 7, 4, 16, 0, 0);
        return cal.getTime();
    }

    /**
     * @return an exemplary RickshawBooking
     */
    public static RickshawBooking mkRickshawBooking() {
        return new RickshawBooking("Eric", mkFutureDate(), "Piccadilly Circus", "Malet Street");
    }

    /**
     * @return an exemplary HotelBooking
     */
    public static HotelBooking mkHotelBooking() {
        return new HotelBooking("Sarah", mkFutureDate(), "Birkbeck Hotel", 45000, 2, 3);
    }

    /**
     * @return an exemplary HotelBooking with negative number of single rooms
     */
    public static HotelBooking mkHotelBookingBad() {
        return new HotelBooking("Charlie", mkFutureDate(), "Some Hotel", 10000, -2, 3);
    }

    /**
     * @return an exemplary RestaurantBooking
     */
    public static RestaurantBooking mkRestaurantBooking() {
        return new RestaurantBooking("Ana", mkFutureDate(), "Birkbeck Restaurant", 8);
    }

    /**
     * @return an exemplary PrintBook
     */
    public static FixedPriceRestaurantBooking mkFixedPriceRestaurantBooking() {
        return new FixedPriceRestaurantBooking("Nikos", mkFutureDate(), "Malet Restaurant", 12, 3000);
    }


    /* Methods that exercise objects in the Booking hierarchy */

    /**
     * Exercises some of the functionality of the class Booking.
     *
     * @param b a Booking, non-null 
     */
    public static void runBooking(Booking b) {
        HotelBooking hb1 = mkHotelBooking();
        System.out.println(hb1);
        System.out.println();

    }
    
    /**
     * Main method for exercising classes from the Booking hierarchy.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        // exercise classes
        Booking[] bookings = {
            mkRickshawBooking(),
            mkHotelBooking(),
            mkRestaurantBooking(),
            mkFixedPriceRestaurantBooking()
        };
        for (Booking b : bookings) {
            System.out.println(b);
            System.out.println();
        }

        // exercise exceptions
        try {
            HotelBooking hb = mkHotelBookingBad();
            System.out.println(hb);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

        // exercise interface implementations
        HasFixedPrice[] fixedPrices = {
            mkFixedPriceRestaurantBooking(),
            mkHotelBooking()
        };
        System.out.println("*** Fixed Prices ***");
        for (HasFixedPrice fixed : fixedPrices) {
            System.out.println("Pence: " + fixed.getFixedPriceInPence());
        }
    }

/*

*** RickshawBooking ***
Name: Eric
Date: Tue Aug 04 16:00:00 BST 2020
Persons: 1
From: Piccadilly Circus
To: Malet Street

*** HotelBooking ***
Name: Sarah
Date: Tue Aug 04 16:00:00 BST 2020
Persons: 8
Location: Birkbeck Hotel
Price: GBP 450.00
Single rooms: 2
Double rooms: 3

*** RestaurantBooking ***
Name: Ana
Date: Tue Aug 04 16:00:00 BST 2020
Persons: 8
Location: Birkbeck Restaurant

*** FixedPriceRestaurantBooking ***
Name: Nikos
Date: Tue Aug 04 16:00:00 BST 2020
Persons: 12
Location: Malet Restaurant
Price: GBP 360.00

java.lang.IllegalArgumentException: Expected at least 0 singleRooms, found: -2

*** Fixed Prices ***
Pence: 36000
Pence: 45000

 */
}
