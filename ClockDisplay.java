
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
    //Permite elegir formato de 12 o 24 horas
    private boolean doceHoras;

    /**
     * Constructor for objects of class ClockDisplay with initial hour is 00:00 or 12:00 in 12 hours format.
     * Elige si quieres el formato horario de 12 horas. 
     */
    public ClockDisplay(boolean formato)
    {
        // minutos actuales
        minute = new NumberDisplay(60);
        // hora actual
        hour = new NumberDisplay(24);
        //Tiempo representado
        time = hour.getDisplayValue() + ":" + minute.getDisplayValue();
        //Formato de horas
        doceHoras = formato;
    }
    
    /**
     * Constructor de objetos de la clase ClockDisplay, el usuario da la hora
     */
    public ClockDisplay(int hora , int minuto, boolean formato)
    {
      // minutos actuales
        minute = new NumberDisplay(60);
        minute.setValue(minuto);
        // hora actual
        hour = new NumberDisplay(24);
        hour.setValue(hora);
        //Tiempo representado
        time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
        //Formato de horas
        doceHoras = formato;
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
       if(doceHoras){
           String meridium = " AM";
           String hora = hour.getDisplayValue();
           if(hour.getValue() > 11){
               if(hour.getValue() > 12){
                   hora = (hour.getValue() - 12) + "";
                }
                meridium  = " PM";
           }
           if((hour.getValue() == 12) && (minute.getValue() == 0)){
               meridium = " M";
           }
           if(hour.getValue() == 0){
               hora = "12";
           }
           if((hour.getValue() > 0) && (hour.getValue() < 10)){
                hora  = "0" + hora;  
           }
           else if((hour.getValue() > 12) && (hour.getValue() < 22)){
               hora  = "0" + hora; 
           }
           String tiempo = hora + ":" + minute.getDisplayValue() + meridium;
           return tiempo;
        }
        else{
            return time;
        }
   }
   
   /**
    * Cambia el formato horario del relos
    */
   public void formatChange(){
       doceHoras  = !doceHoras;
   }
   
   /**
    * Aumenta un minuto el tiempo
    */
   public void timeTick(){
       minute.increment();
       if(minute.getValue() == 0){
           hour.increment();
       }
       time= hour.getDisplayValue() + ":" + minute.getDisplayValue();
   }
}
