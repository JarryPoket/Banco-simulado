package ejemplobanco;
/*import java.util.LinkedList;*/
class Cuenta {
    private String Titular;
    private double Saldo;
    //private double SaldoCristobal;
    private String nombre;
    private String Documento;
   
    public Cuenta(String nombre, String Documento) {
        this.nombre = nombre;
        this.Documento = Documento;
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return Documento;
    }
   
    public double getSaldo() {
        return Saldo;
    }
   
    /*public String getSaldoCristobal() {
        return SaldoCristobal;
    }*/

    Cuenta(Cliente Nestor) {
        Titular = Nestor.nombre;
    }


    boolean consignacion(double x){
       
        boolean peticion = true;
       
        if(peticion == true){
                Saldo = Saldo + x;
                System.out.println("Consignación exitosa. Nuevo saldo: $"+Saldo);
                return true;
        }else{
            return false;
        }  
    }
   
    boolean retirar(double x){
       
        boolean peticion = true;
       
        if(peticion == true){
                Saldo = Saldo - x;
                System.out.println("Retiro exitoso. Nuevo saldo: $"+Saldo);
                return true;
        }else{
            return false;
        }  
    }
   
    public boolean transferir(Cuenta destino, double x){
       
        boolean peticion = true;
        boolean peticionCristobal = true;
       
        if(peticion == true){
            if (peticionCristobal == true){
                Saldo = Saldo - x;
                destino.consignacion(x);
                System.out.println("Transferencia exitosa. Nuevo saldo: $"+Saldo);
                System.out.print("Se le han transferido: $"+destino.getSaldo());
                //System.out.println("a"+destino.getNombre);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }  
    }
      
}