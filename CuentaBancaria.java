import java.util.Scanner;

public class CuentaBancaria {
    String titular;
    String numeroCuenta;
    double saldo;

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void mostrarCuenta() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Cantidad a depositar debe ser positiva.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes para el retiro.");
        } else {
            System.out.println("Cantidad a retirar debe ser positiva.");
        }
    }

    public void transferir(CuentaBancaria cuentaDestino, double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            cuentaDestino.depositar(cantidad);
            System.out.println("Transferencia exitosa. Nuevo saldo: " + saldo);
        } else if (cantidad > saldo) {
            System.out.println("Fondos insuficientes para la transferencia.");
    
        }
}

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria("Gaitan", "123", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Roman", "456", 500.0);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Mostrar Cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Transferir");


        int opcion = scanner.nextInt();
        switch (opcion) {
            
            case 1:
            cuenta1.mostrarCuenta();
            break;
            
            case 2:
                System.out.print("Ingrese la cantidad a depositar: ");
                double cantidadDeposito = scanner.nextDouble();
                cuenta1.depositar(cantidadDeposito);
                cuenta1.mostrarCuenta();
                break;

            case 3:
                System.out.print("Ingrese la cantidad a retirar: ");
                double cantidadRetiro = scanner.nextDouble();
                cuenta1.retirar(cantidadRetiro);
                cuenta1.mostrarCuenta();
                break;

            case 4:
                System.out.print("Ingrese la cantidad a transferir: ");
                double cantidadTransferir = scanner.nextDouble();
                cuenta1.transferir(cuenta2, cantidadTransferir);
                cuenta1.mostrarCuenta();
                cuenta2.mostrarCuenta();
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();


}
}



