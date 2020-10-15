import java.util.Scanner;
public class Principal {
   public static void main(String[] args) {
      mostrarMenu();
   }
   public static void mostrarMenu(){
      Scanner scan = new Scanner(System.in);
      Sensor s = new Sensor();
      Vehiculo v=new Vehiculo(); 
      System.out.println("Ingrese el numero de celdas que tiene el parqueadero");
      int n = scan.nextInt();
      Sensor.sensores = new Sensor[n];
      s.setSensores(Sensor.sensores);
      Vehiculo.parq = new Vehiculo[n];
      int x=1;
      while(x!=0){
         System.out.println(" 1 para imprimir sensores libres  ");
         System.out.println(" 2 solicitar espacio de parqueo cuando no sabe valor comercial");
         System.out.println(" 3 solicitar espacio de parqueo cuando sabe valor comercial");
         System.out.println(" 4 para obtener la info del todos los vehiculos almacenados");
         System.out.println(" 5 historial de vehiculos");
         System.out.println(" 6 estado de un sensor");
         System.out.println(" 7 todos los sensores");
         System.out.println(" 8 todos los vehiculosde un color particular");
         System.out.println(" 9 vehiculos ordenados por valor comercial");
         System.out.println(" 0 para terminar ");
         System.out.println(" Digite la opcion deseada");
         x = scan.nextInt();
         switch(x){
            case 1:
            //String sen = s.sensorLibre(); 
            String sen = Sensor.sensorLibre(); 
            System.out.println(sen);
            break;
            case 2:
            System.out.println("Ingrese el numero de la celda");
            int pos = scan.nextInt();
            if(Vehiculo.parq[pos] != null){
               System.out.println("Este espacio esta ocupado");
            }else{                        
               System.out.println("Ingrese placa de su vehiculo");
               String placa = scan.next();
               System.out.println("Ingrese marca de su vehiculo");
               String marca = scan.next();
               System.out.println("Ingrese color de su vehiculo");
               String color = scan.next();
               Vehiculo v1;
               v1 = new Vehiculo(placa,marca,color);
               Vehiculo.parq[pos]=v1;
               Sensor s1;
               s1 = new Sensor();
               s1.setEstado(1);
               Sensor.sensores[pos]=s1;
               Vehiculo.cantidad++;
               System.out.println("la informacion del vehiculo es " + v1.toString());                        
            }
            break;
            case 3:
            System.out.println("Ingrese el numero de la celda");
            int posicion = scan.nextInt();
            if(Vehiculo.parq[posicion] != null){
               System.out.println("Este espacio esta ocupado");
            }else{
               System.out.println("Ingrese placa de su vehiculo");
               String placa = scan.next();
               System.out.println("Ingrese marca de su vehiculo");
               String marca = scan.next();
               System.out.println("Ingrese color de su vehiculo");
               String color = scan.next();
               System.out.println("Ingrese valor comercial de su vehiculo");
               int valor = scan.nextInt();
               Vehiculo v1 = new Vehiculo(placa,marca,color,valor);
               Vehiculo.parq[posicion]=v1;
               Sensor s1;
               s1 = new Sensor();
               Vehiculo.cantidad++;
               s1.setEstado(1);
               Sensor.sensores[posicion]=s1;
               //Sensor.sensores[posicion].setEstado(1);
               System.out.println("la informacion del vehiculo es " + v1.toString());
            }
            break;
            case 4:
            System.out.println( Vehiculo.toStringVehiculos());
            break;
            case 5:
            System.out.println("La cantidad de vehiculos en el parqueadero es de  " + Vehiculo.cantidad);
            break;
            case 6:
            System.out.println("Digite numero del espacio ");
            int espa = scan.nextInt();
            System.out.println(Sensor.sensores[espa].toString());
            break;
            case 7:
            System.out.println(Sensor.sensoresEstado());
            break;
            case 8:
            System.out.println("Ingrese el color de su vehiculo");
            String colr = scan.next();
            String coloresiguales ="";
            for (int i=0;i<Sensor.sensores.length;i++) {
               if ( Sensor.sensores[i].getEstado()==1 && colr.equals(Vehiculo.parq[i].getColor())) {
                  coloresiguales += Vehiculo.parq[i].toString();
                  System.out.println("encontro uno igual color :>");
               }
            }
            System.out.println(coloresiguales);
            break;
            case 9:
            Vehiculo aux = new Vehiculo("","","",3);
            Vehiculo.parq[0]=aux;
            for(int i =0;i<Vehiculo.parq.length;i++){
               for(int j=i+1;j<Vehiculo.parq.length;j++){
                  if(Vehiculo.parq[i].getvalorComercial() > Vehiculo.parq[j].getvalorComercial()){
                     aux = Vehiculo.parq[j];
                     Vehiculo.parq[j]=Vehiculo.parq[i];
                     Vehiculo.parq[i]=aux;
                  }
               }
            }
            for (Vehiculo parq1 : Vehiculo.parq) {
               System.out.println(parq1.toString());
            }
            break;
            default:
            System.out.println("Comando incorrecto");
            break;
         }         
      }
   }
}