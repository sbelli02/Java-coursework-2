import java.util.Date;

/**
 * A HotelBooking is a LocationBooking with a fixed total price, a number of
 * booked single rooms, and a number of booked double rooms.
 *
 * @author Sandro Bellini
 */
public class HotelBooking extends LocationBooking implements HasFixedPrice {
    /** number of single rooms, must be at least 0. */
    private int singleRooms;
    /** number of double rooms, must be at least 0. */
    private int doubleRooms;
    /** the total price in pence for the booking */
    private int totalPriceInPence;

    /**
     * Constructs a new HotelBooking according to the parameters.
     * Note that at least one room must be booked.
     *
     * @param name the name for which the booking was made; must not be null
     * @param date the point in time for which the booking was made; must not be null
     *  and must not be in the past
     * @param location the address of the hotel; must not be null
     * @param totalPriceInPence the total price in pence for the booking
     * @param singleRooms the number of single rooms, must be at least 0
     * @param doubleRooms the number of double rooms, must be at least 0 
     */
    public HotelBooking(String name, Date date, String location, int totalPriceInPence, int singleRooms, int doubleRooms) {
        super(name,date,location);

        if(singleRooms <0){
            throw new IllegalArgumentException("Expected at least 0 singleRooms, found: " + singleRooms);
        }

        if(doubleRooms <0){
            throw new IllegalArgumentException("Expected at least 0 doubleRooms, found: " + doubleRooms);
        }

        if(singleRooms==0 && doubleRooms==0){
            throw new IllegalArgumentException("at least one room must be booked");
        }

        this.totalPriceInPence =totalPriceInPence;
        this.singleRooms = singleRooms;
        this.doubleRooms = doubleRooms;

    }

    /**
     * @return the total price in pence for the booking
     */
    @Override
    public int getFixedPriceInPence(){
        return this.totalPriceInPence;}

    /**
     * @return the number of single rooms, must be at least 0. In our setting it is assumed that
     * a single room is for one person and a double room is for two persons.
     */
    public int getSingleRooms(){
        return this.singleRooms;
    }

    /**
     * @return the number of double rooms, must be at least 0
     */
    public int getDoubleRooms(){
        return this.doubleRooms;
    }

    /**
     * @return the number of persons for whom the booking has been made, must be at least 1. In our setting it is assumed that
     * a single room is for one person and a double room is for two persons.
     */
    @Override
    public int getNumberOfPersons(){
        return  this.singleRooms + 2* this.doubleRooms;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLocation: " + this.getLocation()
        + "\nPrice: " + this.getFormattedPrice()
        + "\nSingle rooms: " + this.getSingleRooms()
        + "\nDouble rooms: " + this.getDoubleRooms();
    }
}
