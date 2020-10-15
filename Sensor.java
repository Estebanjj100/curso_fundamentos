public class Sensor{
   public static Sensor[] sensores;
   private int estado; 
   public  Sensor(){}
   public Sensor(int e){
      this.estado = e;
   }
   public void setSensores(Sensor[] s){
      for (int i = 0; i < sensores.length;i++){
         Sensor.sensores[i]=new Sensor();
         Sensor.sensores[i].setEstado(0);
      }
      //Sensor.sensores = s;
   }
   public void setEstado(int e){
      this.estado = e;
   }
   public Sensor[] getSensores(){
      return Sensor.sensores;
   }
   public int getEstado(){
      return this.estado;
   }
   @Override
   public String toString(){
      String a;
      if(estado==0){
         a = "Libre";
      } else {
         a = "Ocupado";
      }
      return a;
   }
   public static String sensorLibre(){
      String libres = "";
      for(int i=0;i<sensores.length;i++){
         if(Sensor.sensores[i].getEstado() == 0){
            libres = libres +" - "+ i;
         }
      }
      return libres;
   }
   public static String sensoresEstado(){
      String estadocelda = " - ";
      for (int i =0;i<sensores.length;i++) {
         estadocelda = "  "+ estadocelda + Sensor.sensores[i].toString();
      }
      return estadocelda;
   }
}