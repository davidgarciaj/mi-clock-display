
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
    //Asigna el dia actual
    private NumberDisplay dia;
    //Asigna el mes actual
    private NumberDisplay mes;
    //Asigna el año actual
    private NumberDisplay year;

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
        //Formato de horas, true es formato 12 horas
        doceHoras = formato;
        //Dia actual
        dia = new NumberDisplay(30);
        dia.setValue(20);
        //Mes actual
        mes = new NumberDisplay(12);
        mes.setValue(11);
        //Año actual
        year = new NumberDisplay(100);
        year.setValue(15);
        //Tiempo representado
        asignaTime();
    }
    
    /**
     * Constructor de objetos de la clase ClockDisplay, el usuario da la hora
     * * Elige si quieres el formato horario de 12 horas
     */
    public ClockDisplay(int hora , int minuto, boolean formato, int diaDado, int mesDado, int anioDado)
    {
      // minutos actuales
        minute = new NumberDisplay(60);
        minute.setValue(minuto);
        // hora actual
        hour = new NumberDisplay(24);
        hour.setValue(hora);
        //Formato de horas
        doceHoras = formato;
        //Dia actual
        dia = new NumberDisplay(30);
        dia.setValue(diaDado);
        //Mes actual
        mes = new NumberDisplay(12);
        mes.setValue(mesDado);
        //Año actual
        year = new NumberDisplay(100);
        year.setValue(anioDado);
        //Tiempo representado
        asignaTime();
    }

    /**
     * Fija la hora que desees introducir,tambien debes fijar el dia, mes y año.
     */
    public void setTime(int hora,int minuto, int diaDado, int mesDado, int anioDado)
   {
        //Hora actual
        hour.setValue(hora);
        //Minuto actual
        minute.setValue(minuto);
        //Dia actual
        dia.setValue(diaDado - 1);
        //Mes actual
        mes.setValue(mesDado - 1);
        //Año actual
        year.setValue(anioDado);
        //Guarda fecha
        asignaTime();
   }
   
   /**
    * Devuelve la hora en una cadena
    */
   public String getTime()
   {
       asignaTime();
       return time;
        
   }
   
   /**
    * Cambia el formato horario del relos
    */
   public void formatChange(){
       doceHoras  = !doceHoras;
       asignaTime();
   }
   /**
    * Asigna el valor de la hora
    */
   public void asignaTime(){
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
           time = hora + ":" + minute.getDisplayValue() + meridium + " " + (dia.getValue() + 1) + "-" + (mes.getValue()+ 1) + "-" + year.getDisplayValue(); 
        }
       else{
           time = hour.getDisplayValue() + ":" + minute.getDisplayValue() + " " + (dia.getValue()+ 1) + "-" + (mes.getValue()+ 1) + "-" + year.getDisplayValue();
       }
   }
   
   /**
    * Aumenta un minuto el tiempo
    */
   public void timeTick(){
       minute.increment();
       if(minute.getValue() == 0){
           hour.increment();
           if(hour.getValue() == 0){
               dia.increment();
               if(dia.getValue() == 0){
                   mes.increment();
                   if(mes.getValue() == 0){
                       year.increment();
                   }
               }
           }
       }
       asignaTime();
   }
}
