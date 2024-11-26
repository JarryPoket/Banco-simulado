package ejemplobanco;
    import java.util.HashMap;
    import java.util.Scanner;
/*
 * @author santi
 */
public class EjemploBanco {
    private static HashMap<String, Cuenta> cuentas = new HashMap<>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Banco Simulado ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Consignar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Transferir dinero");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> consultarSaldo();
                case 3 -> consignar();
                case 4 -> retirar();
                case 5 -> transferir();
                case 6 -> System.out.println("Gracias por usar el Banco Simulado.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void crearCuenta() {
        System.out.print("Ingrese su nombre: ");
        String nombre = s.nextLine();
        System.out.print("Ingrese su documento: ");
        String documento = s.nextLine();
        if (cuentas.containsKey(documento)) {
            System.out.println("Ya existe una cuenta con este documento.");
        } else {
            cuentas.put(documento, new Cuenta(nombre, documento));
            System.out.println("Cuenta creada exitosamente.");
        }
    }

    private static void consultarSaldo() {
        Cuenta cuenta = buscarCuenta();
        if (cuenta != null) {
            System.out.println("Saldo actual: $" + cuenta.getSaldo());
        }
    }

    private static void consignar() {
        Cuenta cuenta = buscarCuenta();
        if (cuenta != null) {
            System.out.print("Ingrese el monto a consignar: ");
            double x = s.nextDouble();
            cuenta.consignacion(x);
        }
    }

    private static void retirar() {
        Cuenta cuenta = buscarCuenta();
        if (cuenta != null) {
            System.out.print("Ingrese el monto a retirar: ");
            double x = s.nextDouble();
            cuenta.retirar(x);
        }
    }

    private static void transferir() {
        System.out.print("Ingrese el documento de su cuenta: ");
        String docOrigen = s.nextLine();
        Cuenta cuentaOrigen = cuentas.get(docOrigen);

        if (cuentaOrigen == null) {
            System.out.println("No se encontró la cuenta origen.");
            return;
        }

        System.out.print("Ingrese el documento de la cuenta destino: ");
        String docDestino = s.nextLine();
        Cuenta cuentaDestino = cuentas.get(docDestino);

        if (cuentaDestino == null) {
            System.out.println("No se encontró la cuenta destino.");
            return;
        }

        System.out.print("Ingrese el monto a transferir: ");
        double x = s.nextDouble();
        cuentaOrigen.transferir(cuentaDestino, x);
    }

    private static Cuenta buscarCuenta() {
        System.out.print("Ingrese su documento: ");
        String documento = s.nextLine();
        Cuenta cuenta = cuentas.get(documento);
        if (cuenta == null) {
            System.out.println("No se encontró ninguna cuenta con este documento.");
        }
        return cuenta;
    }
}