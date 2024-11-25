package modelo;

//Superclase
public class Animal {
 String nombre;

 void comer() {
     System.out.println(nombre + " está comiendo.");
 }

 void dormir() {
     System.out.println(nombre + " está durmiendo.");
 }
}

//Subclase
class Perro extends Animal {
 void ladrar() {
     System.out.println(nombre + " está ladrando.");
 }
}



