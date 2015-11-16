
/**
 * Reloj en el que se puede fijar la hora y minutos, aumentar los minutos y devolver la hora que tenemos
 * 
 * @author (David Garcia) 
 * @version (1.0)
 */
public class ClockDisplay
{
    // Representa los minutos
    private NumberDisplay minute;
    // Representa las horas
    private NumberDisplay hour;
    //La hora que tiene el reloj en cadena de caracteres
    private String time;

    /**
     * Constructor for objects of class ClockDisplay with initial hour is 00:00
     */
    public ClockDisplay()
    {
        // minutos actuales
        minute.setValue(0) ;
        // hora actual
        hour.setValue(0);
        //Tiempo representado
        time= hour + ":" + minute;
    }
    
    /**
     * Constructor for objects of class ClockDisplay with a user gift the initial hour
     */
    public ClockDisplay(int hora , int minuto)
    {
        // minutos actuales
        minute.setValue(minuto);
        // hora actual
        hour.setValue(hora);
        //Tiempo representado
        time= hour + ":" + minute;
    }

}
