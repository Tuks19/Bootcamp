public class Persona {
    private String Nombre;
    private int edad;
//Constructor
    public Persona(String Nombre, int edad) {
        this.Nombre = Nombre;
        this.edad = edad;
    }
//Metodos
    public void Saludar(){
        System.out.println ("Buenas, soy:"+ Nombre + "y tengo "+ edad+" anhos");
    }

//Fin Metodos

// Setters y Getters
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
// Fin de Setters y Getters

}


