
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
        minute = new NumberDisplay(60);
        // hora actual
        hour = new NumberDisplay(24);
        //Tiempo representado
        time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
    }
    
    /**
     * Constructor for objects of class ClockDisplay with a user gift the initial hour
     */
    public ClockDisplay(int hora , int minuto)
    {
      // minutos actuales
        minute = new NumberDisplay(60);
        minute.setValue(minuto);
        // hora actual
        hour = new NumberDisplay(24);
        hour.setValue(hora);
        //Tiempo representado
        time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
    }

    /**
     * Fija la hora que desees introducir
     */
    public void setTime(int hora,int minuto)
   {
        hour.setValue(hora);
        minute.setValue(minuto);
        time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
   }
   
   /**
    * Devuelve la hora en una cadena
    */
   public String getTime()
   {
       time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
       return time;
   }
   
   /**
    * Aumenta un minuto el tiempo
    */
   public void timeTick(){
       minute.increment();
       if(minute.getValue() == 0){
           hour.increment();
       }
   }
}
