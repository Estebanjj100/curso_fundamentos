public class Vehiculo {
   public static Vehiculo[] parq;
   public static int cantidad = 0;
   private String placa;
   private String marca;
   private String color;
   private int valorComercial;
   public Vehiculo(){}
   public Vehiculo(String p, String m, String c,int v){
      this.placa = p;
      this.marca = m;
      this.color = c;
      this.valorComercial = v;
      Vehiculo.cantidad = cantidad++;
   }
   public Vehiculo(String p, String m, String c){
      this(p,m,c, 30000000);
      Vehiculo.cantidad = cantidad++;
   }
   public void setPlaca(String p){
      this.placa = p;
   }
   public void setMarca(String m){
      this.marca = m;
   }
   public void setColor(String c){
      this.color = c;
   }
   public void setvalorComercial(int v){
      this.valorComercial = v;
   }
   public String getPlaca(){
      return this.placa;
   }
   public String getMarca(){
      return this.marca;
   }
   public String getColor(){
      return this.color;
   }
   public int getvalorComercial(){
      return this.valorComercial;
   }
   @Override
   public  String toString(){
      return "Placa " + placa+" Marca "+marca+" Color "+color+" Valor "+valorComercial +"\n";
   }
   public static int cantidadVehiculos(){
      return cantidad;
   }
   public static String toStringVehiculos(){
      String vehiculos1 = "";
      for (int i=0; i<Vehiculo.parq.length;i++) {
         if (Vehiculo.parq[i] != null) {
            vehiculos1 = vehiculos1 + "Placa " + Vehiculo.parq[i].placa + "Marca "+ Vehiculo.parq[i].marca + "Color "+Vehiculo.parq[i].color+"Valor "+Vehiculo.parq[i].valorComercial+ "\n";
         }
      }
      return vehiculos1;
   }
}