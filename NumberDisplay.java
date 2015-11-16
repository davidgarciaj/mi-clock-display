
/**
 * The class have a number of two digits.
 * 
 * @author (David Garcia) 
 * @version (1)
 */
public class NumberDisplay
{
    // instance variables - replace the example below with your own
    private int number;
    private int limit;

    /**
     * Constructor for objects of class NumberDisplay with a maxime valor.
     */
    public NumberDisplay( int max)
    {
        // valor original de number.
        number = 0;
        //valor del limite maximo.
        limit = max;
    }

    /**
     * A method for grow up the number.
     */
    public void increment()
    {
        // grow up the number
        number++;
        if(number == limit){
            number = 0;
        }
    }
    /**
     * Give a new Value for the number,
     * If the value is negative the method give him 0,
     * If the value is more to limit, the value is the rest of value/limit.
     */
    public void setValue(int giveMe){
        number = giveMe;
        if(giveMe >= limit){
            number = limit - 1;
        }
        else if(giveMe<0){
            number = 0;
        }
    }
    /**
     * Return a chain of 2 character.
     */
    public String getDisplayValue(){
        String value = Integer.toString(number);
        if(number < 10){
            value = "0" + value;
        }
        return value;
    }
    /**
     * Return a number.
     */
    public int getValue(){
        return number;
    }
}
