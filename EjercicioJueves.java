import java.util.ArrayList;
import java.util.List;


public class SistemaVehiculos {


    public static void main(String[] args) {
    
        Vehiculo vehiculoGenerico = new Vehiculo("Genérico", "2023");
        Vehiculo miCoche = new Coche("Toyota", "Corolla"); 
        Vehiculo miMoto = new Motocicleta("Honda", "CBR500R"); 


        List<Vehiculo> misVehiculos = new ArrayList<>();
        misVehiculos.add(vehiculoGenerico);
        misVehiculos.add(miCoche);
        misVehiculos.add(miMoto);

        System.out.println("--- Demostración de Polimorfismo en Java ---");

     
        for (Vehiculo vehiculo : misVehiculos) {
            vehiculo.mostrarInformacion();
            vehiculo.acelerar();
            System.out.println("--------------------");
        }
    }
}


class Vehiculo {

    protected String marca;
    protected String modelo;


    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInformacion() {
        System.out.println("Vehículo: " + this.marca + " " + this.modelo);
    }

    public void acelerar() {
        System.out.println("El " + this.marca + " está acelerando");
    }
}


class Coche extends Vehiculo {
    

    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }


    @Override
    public void acelerar() {
        System.out.println("El coche " + this.marca + " pisa el pedal a fondo y sale botado");
    }
}


class Motocicleta extends Vehiculo {

    public Motocicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("La motocicleta " + this.marca + " gira el acelerador y lista para tirar gancho");
    }
}