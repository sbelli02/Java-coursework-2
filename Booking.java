import java.util.Date;

/**
 * Abstract superclass for our Booking hierarchy. A booking provides a name,
 * a date (the point in time for which the booking was made), and a number
 * of persons.
 *
 * @author Sandro Bellini
 */
public abstract class Booking {

    /** The name for which the booking was made. Non-null. */
    private String name;

    /** The point in time for which the booking was made. Non-null. */
    private Date date;

    /**
     * Constructs a new Booking with a name and a date.
     *
     * @param name the name for which the booking was made; must not be null
     * @param date the point in time for which the booking was made;
     *  must not be null and must not be in the past
     */
    public Booking(String name, Date date) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null!");
        }
        if (date == null) {
            throw new IllegalArgumentException("date must not be null!");
        }
        if (date.before(new Date())) {
            throw new IllegalArgumentException("date must not be in the past, found: " + date);
        }
        this.name = name;
        this.date = date;
    }

    /**
     * Returns the number of persons for whom the booking has been made.
     * Concrete subclasses will need to provide a suitable implementation.
     *    
     * @return the number of persons for which the booking has been made,
     *  greater than or equal to zero
     */
    public abstract int getNumberOfPersons();

    /**
     * @return the name of the booking, non-null
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the point in time for which the booking has been made, non-null
     */
    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "*** " + this.getClass().getName()
                + " ***\nName: " + this.getName()
                + "\nDate: " + this.getDate()
                + "\nPersons: " + this.getNumberOfPersons();
    }
}
