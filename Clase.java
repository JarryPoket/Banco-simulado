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
                System.out.println("Consignación exitosa");
                String name = getNombre();
                System.out.println("Nuevo saldo de "+name+" $"+Saldo);
                return true;
        }else{
            return false;
        }  
    }
   
    boolean retirar(double x){
       
        boolean peticion = true;
       
        if(peticion == true){
            if(x>Saldo){
                System.out.println("Saldo insuficiente");
            }else{
                Saldo = Saldo - x;
                String name = getNombre();
                System.out.println("Retiro exitoso. Nuevo saldo de"+name+" $"+Saldo);
                return true;
            }
            
        }
        return false;
    }
   
    public boolean transferir(Cuenta destino, double x){
       
        boolean peticion = true;
        boolean peticionCristobal = true;
       
        if(peticion == true){
            if (peticionCristobal == true){
                if (x*1.004>Saldo){
                    System.out.println("Saldo insuficiente");
                }else{
                    Saldo = Saldo - (x*1.004);
                    String name = getNombre();
                    destino.consignacion(x);
                    System.out.println("Transferencia exitosa. Nuevo saldo de"+name+" $"+Saldo);
                    System.out.print("Se le han transferido: $"+destino.getSaldo());
                    return true;
                
            }
        }
    }
        return false;
    }
}