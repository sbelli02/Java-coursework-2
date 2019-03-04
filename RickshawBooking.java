import java.util.Date;

/**
 * A RickshawBooking is a booking for travelling from a start point to a
 * destination point via a rickshaw taxi. In our setting, a rickshaw
 * always transports exactly one passenger.
 *
 * @author Sandro Bellini.
 */
public class RickshawBooking extends Booking {
    /**  Starting point of the rickshaw travel. Non-null. */
    private String from;
    /**  Destination point of the rickshaw travel. Non-null. */
    private String to;

    /**
     * Constructs a RickshawBooking object according to the parameters.
     *
     * @param name the name for which the booking was made; must not be null
     * @param date the point in time for which the booking was made; must not be null
     *  and must not be in the past
     * @param from the start point of the rickshaw travel; must not be null
     * @param to the destination point of the rickshaw travel; must not be null
     */
    public RickshawBooking(String name, Date date, String from, String to) {
        super(name,date);
        if (from == null) {
            throw new IllegalArgumentException("from must not be null!");
        }
        if (to == null) {
            throw new IllegalArgumentException("to must not be null!");
        }
        this. from = from;
        this. to = to;

    }
    
    /**
     * @return the starting point of the rickshaw travel. Non-null.
     */
    public String getFrom() {
        return this.from;
    }
   
    /**
     * @return the destination point of the rickshaw travel. Non-null.
     */
    public String getTo() {
        return this.to;
    }
    
    /**
     * @return the number of persons for which the booking has been made,
     * in our setting, a rickshaw always transports exactly one passenger.
     */
    @Override
    public int getNumberOfPersons(){
        return 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFrom: " + this.getFrom()
        + "\nTo: " + this.getTo();
    }
}
