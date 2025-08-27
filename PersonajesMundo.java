abstract class Personaje {
    private String nombre;
    private Integer salud; 
    protected String secreto;
    
    public Personaje(String nombre, Integer salud) {
        this.nombre = nombre;
        this.salud = salud;
        this.secreto = "Secreto no revelado";
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getSalud() {
        return salud;
    }
    
    public void setSalud(Integer salud) {
        if (salud >= 0) {
            this.salud = salud;
        }
    }
    
    public abstract void actuar();
    
    public void revelarSecreto() {
        System.out.println(nombre + " revela: " + secreto);
    }
}

class Guerrero extends Personaje {
    private int fuerza;
    
    public Guerrero(String nombre, Integer salud, Integer fuerza) {
        super(nombre, salud);
        this.fuerza = fuerza;
        this.secreto = "Mi fuerza viene de algo magico";
    }
    
    public void actuar() {
        System.out.println(getNombre() + " ataca con fuerza " + fuerza);
    }
    
    public void entrenar() {
        fuerza += 5;
        System.out.println(getNombre() + " ha entrenado y su fuerza es ahora " + fuerza);
    }
}

class Mago extends Personaje {
    private Integer mana;
    
    public Mago(String nombre, Integer salud, Integer mana) {
        super(nombre, salud);
        this.mana = mana;
        this.secreto = "Conozco algo";
    }
    
    public void actuar() {
        System.out.println(getNombre() + " lanza un hechizo con mana " + mana);
        mana = mana - 10;
    }
    
    public void meditar() {
        mana = mana + 15;
        System.out.println(getNombre() + " ha meditado y su mana es ahora " + mana);
    }
}

public class PersonajesMundo {
    public static void main(String[] args) {
        Personaje[] personajes = new Personaje[2];
        
        personajes[0] = new Guerrero("Roman", 100, 50);
        personajes[1] = new Mago("Medina", 80, 60);
        
        for (Personaje p : personajes) {
            p.actuar();
            p.revelarSecreto();
        }
        
        Guerrero g = (Guerrero) personajes[0];
        g.entrenar();
        
        Mago m = (Mago) personajes[1];
        m.meditar();
        
        System.out.println("Salud de " + g.getNombre() + ": " + g.getSalud());
    }

}