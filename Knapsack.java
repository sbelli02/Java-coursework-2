
import java.util.*;
import java.util.ArrayList;
/**
 * A Knapsack holds zero or more Items and can provide information about the
 * Items. One can add Items to a Knapsack during its lifetime, reset the
 * Knapsack, create a copy which contains Items only up to a certain weight,
 * and make various queries to the Knapsack. (Thus, the number of Items that
 * will be stored by a Knapsack object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a Knapsack
 * object.)
 *
 * @author Sandro Bellini
 */
// declaring the instance variables
public class Knapsack {
    private ArrayList<Item> list;
    private int numberOfItems;
    private double averageWeight;

    /**
     * Constructs a new Knapsack without any Items.
     */    
    public Knapsack() {

        numberOfItems = 0;
        averageWeight = 0;
        list = new ArrayList<Item>();
    }

    /**
     * Constructs a new Knapsack containing the non-null Items in items.
     * The items array may be modified by the caller afterwards without
     * affecting this Knapsack, and it will not be modified by this
     * constructor.
     *
     * @param items must not be null; non-null elements are added to the
     *  constructed Knapsack
     */
    public Knapsack(Item[] items) {
        this();
        for (int i = 0; i < items.length; i++) {
            if(items[i]!=null){
                this.list.add(items[i]);
            }
        }

    }

    /* Modifiers */

    /**
     * Adds an Item e to this Knapsack if e is not null; does not modify this
     * Knapsack otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an item to be added to this Knapsack
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item e) {
        if(e!=null){
            this.list.add(e);
            return true;
        }
        return false;
    }

    /**
     * Adds all non-null Items in items to this Knapsack.
     *
     * @param items contains the Item objects to be added to
     *  this Knapsack; must not be null (but may contain null)
     * @return true if at least one element of items is non-null;
     *  false otherwise
     */
    public boolean addAll(Item[] items) {
        boolean flag = false;
        for (int i = 0; i < items.length; i++) {
            if(items[i]!=null){
                this.list.add(items[i]);
                flag =true;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }

    /**
     * Resets this Knapsack to a Knapsack that contains 0 Items.
     */
    public void reset() {
        this.list = new ArrayList<Item>() ;

    }

    /**
     * Removes certain Items from this Knapsack. Exactly those Items are kept
     * whose weight in grammes is less than or equal to the specified maximum
     * weight in grammes.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {

        Iterator<Item> iterator = this.list.iterator();

        while(iterator.hasNext()){
            Item item = iterator.next();
            if(item.getWeightInGrammes()>maxItemWeightInGrammes || item == null){
                iterator.remove();
            }

        }

    }
    /* Accessors */
    /**
     * Returns the number of non-null Items in this Knapsack.
     *
     * @return the number of non-null Items in this Knapsack
     */
    public int numberOfItems() {
        numberOfItems = this.list.size();
        return numberOfItems;
    }

    /**
     * Returns the total weight of the Items in this Knapsack.
     *
     * @return the total weight of the Items in this Knapsack.
     */
    public int totalWeightInGrammes() {
        int total=0;
        for(Item item : this.list){
            total+= item.getWeightInGrammes();
        }

        return total;
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this Knapsack. In case there is no Item in this Knapsack,
     * -1.0 is returned.
     *
     * For example, if this Knapsack has the contents
     *   new Item("Soda", 400)
     * and
     *   new Item("Water", 395),
     * the result is: 397.5
     *
     * @return the average length of the Items in this Knapsack,
     *  or -1.0 if there is no such Item.
     */
    public double averageWeightInGrammes() {
        if(this.list.size()==0){
            return -1.0;
        }
        double total = totalWeightInGrammes();
        averageWeight =  total/numberOfItems() ;
        return averageWeight;
    }

    /**
     * Returns the greatest Item in this Knapsack according to the
     * natural ordering of Item given by its compareTo method;
     * null if this Knapsack does not contain any Item objects
     *
     * @return the greatest Item in this Knapsack according to the
     *  natural ordering of Item given by its compareTo method;
     *  null if this Knapsack does not contain any Item objects
     */
    public Item greatestItem() {
        if (this.list.isEmpty()) {
            return null;
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    /**
     * Returns a new Knapsack with exactly those Items of this Knapsack
     * whose weight is less than or equal to the specified method parameter.
     * Does not modify this Knapsack.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items in the new Knapsack
     * @return a new Knapsack with exactly those Items of this Knapsack
     *  whose weight is less than or equal to the specified method parameter
     */
    public  Knapsack makeNewKnapsackWith(int maxItemWeightInGrammes) {
        Knapsack newSack =  new Knapsack();

        for(Item item : list){
            if (item.getWeightInGrammes()<=maxItemWeightInGrammes){
                newSack.list.add(item);
            }

        }
        return  newSack;
    }

    /**
     * Returns a string representation of this Knapsack. The string
     * representation consists of a list of the Knapsack's contents,
     * enclosed in square brackets ("[]"). Adjacent Items are
     * separated by the characters ", " (comma and space). Items are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * Item i1 = new Item("Pen", 15);
     * Item i2 = new Item("Letter", 20);
     * Item i3 = null;
     * Item[] items = { i1, i2, i3, i1 };
     * Knapsack k = new Knapsack(items);
     *
     * the call k.toString() will return one of the three following Strings:
     *
     * "[(Pen, 15), (Pen, 15), (Letter, 20)]"
     * "[(Pen, 15), (Letter, 20), (Pen, 15)]"
     * "[(Letter, 20), (Pen, 15), (Pen, 15)]"
     *
     * @return a String representation of this Knapsack
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String data ="";
        if(this.list.size()==0){
            return "[]";
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)!=null){
                data+= list.get(i).toString();}
            if(i<this. list.size() - 1){
                data+=", ";}
        }   
        return "["+data+"]";
    }

    /* class methods */

    /**
     * Class method to return a Knapsack with the highest total weight from an
     * array of Knapsacks. If we have an array with a Knapsack of 3000 grammes
     * and a Knapsack with 4000 grammes, the Knapsack with 4000 grammes is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several Knapsacks with the same weight, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param knapsacks must not be null, but may contain null
     * @return one of the Knapsacks with the highest total weight among all
     *  Knapsacks in the parameter array; null if there is no non-null
     *  reference in knapsacks
     */
    public static Knapsack heaviestKnapsack(Knapsack[] knapsacks) {
        Knapsack highest =  new Knapsack();
        int heaviest = 0;

        if (knapsacks.length==0) {
            return null;
        }
        for (int i = 0; i < knapsacks.length; i++) {
            if(knapsacks[i].totalWeightInGrammes()>=heaviest){
                heaviest = knapsacks[i].totalWeightInGrammes();
                highest= knapsacks[i];
            }
        }

        return highest;

    }
}

