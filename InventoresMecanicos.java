import java.util.ArrayList;

class Inventor {
    private String nombre;
    private Integer edad;
    private Integer creatividad;

    public Inventor(String nombre, Integer edad, Integer creatividad) {
        this.nombre = nombre;
        this.edad = edad;
        this.creatividad = creatividad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getCreatividad() {
        return creatividad;
    }

    public void otorgarPuntosCreatividad(Integer puntos) {
        if (puntos > 0) {
            creatividad += puntos;
        }
    }

    public void presentarInvento() {
        System.out.println("Presentando invento...");
    }
}

class InventorMecanico extends Inventor {
    public InventorMecanico(String nombre, Integer edad, Integer creatividad) {
        super(nombre, edad, creatividad);
    }

    @Override
    public void presentarInvento() {
        System.out.println(getNombre() + " presenta un carro que vuela con las llantas / Creatividad: " + getCreatividad() + "!");
    }
}

class InventorProgramador extends Inventor {
    public InventorProgramador(String nombre, Integer edad, Integer creatividad) {
        super(nombre, edad, creatividad);
    }

    @Override
    public void presentarInvento() {
        System.out.println(getNombre() + " presenta un software que recarga la bateria mientras se escucha musica / Creatividad: " + getCreatividad() + "!");
    }
}

class InventorQuimico extends Inventor {
    public InventorQuimico(String nombre, Integer edad, Integer creatividad) {
        super(nombre, edad, creatividad);
    }

    @Override
    public void presentarInvento() {
        System.out.println(getNombre() + " presenta un producto que con los gases del carro agarra mas velocida / Creatividad: " + getCreatividad() + "!");
    }
}



public class InventoresMecanicos {
    public static void main(String[] args) {
        ArrayList<Inventor> inventores = new ArrayList<>();

        inventores.add(new InventorMecanico("1", 30, 70));
        inventores.add(new InventorProgramador("2", 25, 85));
        inventores.add(new InventorQuimico("3", 35, 90));
        

        
        System.out.println("\nPuntos de creatividad...\n");
        inventores.get(0).otorgarPuntosCreatividad(10);
        inventores.get(1).otorgarPuntosCreatividad(5);
        inventores.get(2).otorgarPuntosCreatividad(15);
        

        
        System.out.println("Presentaciones jurado:\n");
        for (Inventor inventor : inventores) {
            inventor.presentarInvento();
        }
    }
}

