/**
 * Classes implementing this interface provide methods that returns a fixed
 * price as an int in pence or as a formatted String. This interface also
 * provides convenience functionality to generate a string representation
 * from an amount of money given in pence.
 *
 * @author Sandro Bellini
 */
public interface HasFixedPrice {

    /**
     * Returns a fixed price in pence for this object.
     *
     * @return a fixed price in pence for this object
     */
    int getFixedPriceInPence();

    /**
     * Provides a formatted String representation of an amount in pence.
     *
     * @param priceInPence  amount in pence
     * @return a formatted String representation of the given amount in pence
     */
    static String computeFormattedPrice(int priceInPence) {
        int pounds = priceInPence / 100;
        int pence = priceInPence % 100;
        return "GBP " + pounds + "." + (pence < 10 ? "0" : "") + pence;
    }

    /**
     * Returns a formatted String representation of the fixed price of this object.
     *
     * @return a formatted String representation of the fixed price of this object
     */
    default String getFormattedPrice() {
        return computeFormattedPrice(this.getFixedPriceInPence());
    }

}
